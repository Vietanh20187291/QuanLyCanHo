/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.GiaoDichDAL;
import Entities.GiaoDich;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static DAL.GiaoDichDAL.listGD;
import Entities.DotThanhToan;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Vanh
 */
public class GiaoDichBLL {

    private GiaoDichBLL() {

    }

    public static void show(JTable tbl) {

        List<GiaoDich> dsgd = listGD();
        loadTable(tbl, dsgd);

    }

    public static void loadTable(JTable tbl, List listgd) {

        List<GiaoDich> list = listgd;
        Object[] colName = {"STT", "Mã Giao Dịch ", "Ngày Giao Dịch", "Số Tiền ", "Mã Đợt Thanh Toán", "Mã Hợp Đồng", "Mã Khách Hàng", "Mã Nhân Viên", "Tên Nhân Viên"};
        Object[][] data = new Object[list.size()][colName.length];
        int row = 0;
        for (GiaoDich gd : list) {
            data[row][0] = (row + 1);
            data[row][1] = gd.getMaGiaoDich();
            data[row][2] = convertToDate(gd.getNgayGiaoDich());
            data[row][3] = convertMoney(gd.getSoTien());
            data[row][4] = gd.getMaDotTT();
            data[row][5] = gd.getMaHopDong();
            data[row][6] = gd.getMaKhachHang();
            data[row][7] = gd.getMaNhanVien();
            data[row][8] = gd.getTenNhanVien();
            row++;
        }

        TableModel tableModel = new DefaultTableModel(data, colName);
        tbl.setModel(tableModel);
    }

    private static String convertMoney(Long number) {
        String numberInText = String.valueOf(number);

        int numberLength = numberInText.length();

        if (numberLength < 4) {
            return numberInText;
        }

        StringBuilder sb = new StringBuilder("");

        for (int i = 0, j = numberLength % 3 == 0 ? 3 : numberLength % 3; i < numberLength; ++i) {

            if (j < numberLength && i == j) {
                sb.append(".");
                j += 3;
            }

            sb.append(numberInText.charAt(i));
        }

        return sb.toString();
    }

    public static boolean insert(GiaoDich gd) throws ParseException, Exception {
        String magd = getMaGiaoDichMoi();
        if (listGD().size() < 9) {
            magd = "GD000" + (listGD().size() + 1);
        } else {
            magd = "GD00" + (listGD().size() + 1);
        }
        gd.setMaGiaoDich(magd);
        String ngaygd = "" + java.time.LocalDate.now();
        gd.setNgayGiaoDich(convertDateToLong(ngaygd));
        return GiaoDichDAL.insert(gd);
    }

    public static String getMaGiaoDichMoi() throws Exception {
        String magd = null;
        try {
            List<GiaoDich> dsGD = DAL.GiaoDichDAL.listGD();
            String maGDcuoi = dsGD.get(listGD().size() - 1).getMaHopDong();
            Integer hdsize = Integer.valueOf(maGDcuoi.substring(3, 6));
            if (hdsize < 9) {
                magd = "GD000" + (listGD().size() + 1);
            } else if (hdsize < 99) {
            magd = "GD00" + (listGD().size() + 1);
            } else {
            magd = "GD0" + (listGD().size() + 1);
            }
        } catch (Exception e) {
            System.out.println("GetGDMoiBLL" + e.getMessage());
        }
        return magd;
    }

    public static void search(JTable tbl, String text) throws SQLException, ParseException {
        List<GiaoDich> dsgd = DAL.GiaoDichDAL.search(text);
        loadTable(tbl, dsgd);
    }

    public static String convertToDate(Long value) {
        Date date = new Date(value);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dateText = df.format(date);
        return dateText;
    }

    public static Long convertDateToLong(String string_date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date) formatter.parse(string_date);
        long mills = date.getTime();
        return mills;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(convertDateToLong("2022-02-01") - convertDateToLong("2022-01-01"));
        //  System.out.println(getLateMoney(1L));
    }

}
