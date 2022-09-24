/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.HopDongDAL;
import Entities.CanHo;
import Entities.HopDong;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vanh
 */
public class HopDongBLL {

    public static void LoadTable(JTable tbl, List list) {
        try {
            List<HopDong> dsHopDong = list;
            Object[] colName = new Object[]{"Mã hợp đồng", "Tên khách hàng", "Mã Khách", "Mã căn hộ", "Giá", "Đã Thanh Toán", "Còn Thiếu", "Ngày giao dịch", "Thời hạn thanh toán"};
            Object[][] data = new Object[dsHopDong.size()][9];
            int i = 0;
            for (HopDong hd : dsHopDong) {
                data[i][0] = hd.getMaHopDong();
                data[i][1] = hd.getTenKH();
                data[i][2] = hd.getMaCuDan();
                data[i][3] = hd.getMaCanHo();
                data[i][4] = convertMoney(hd.getGia());
                data[i][5] = convertMoney(hd.getDaThanhToan());
                data[i][6] = convertMoney(hd.getGia() - hd.getDaThanhToan());
                data[i][7] = "" + hd.getNgayGiaoDich();
                data[i][8] = "" + hd.getThoiHan();
                i++;
            }

            TableModel tableModel = new DefaultTableModel(data, colName);
            tbl.setModel(tableModel);
        } catch (Exception e) {
            System.out.println("LoadTable Exception = " + e.getMessage());

        }
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

    public static void HienThongTinMuaBan(JTable tbl) throws Exception {
        try {
            List<HopDong> dsHopDong = DAL.HopDongDAL.dsHopDong();
            LoadTable(tbl, dsHopDong);
        } catch (Exception e) {
            System.out.println("HienThitt" + e.getMessage());
        }
    }
    public static String getMaHopDongMoi() throws Exception {
        String mahd = null;
        try {
            List<HopDong> dsHopDong = DAL.HopDongDAL.dsHopDong();
            String mahdcuoi = dsHopDong.get(dsHopDong.size()-1).getMaHopDong();
            Integer hdsize =Integer.valueOf(mahdcuoi.substring(3,6));
        if (hdsize < 9) {
            mahd = "HD000" + (hdsize + 1);
        } else if(hdsize < 99){
            mahd = "HD00" + (hdsize + 1);
        }else{
            mahd = "HD0" + (hdsize + 1);
        }
        } catch (Exception e) {
            System.out.println("GetHDMoiBLL" + e.getMessage());
        }
        return mahd;
    }

    public static String insertHD_BLL(String diachikh, String macd, String mach, long datt, String th, String manv, long gia, long coc) throws SQLException, Exception {
        String mahd = getMaHopDongMoi();
        String ngaygd = "" + java.time.LocalDate.now();
        HopDongDAL.insertHD_DAL(mahd, ngaygd, diachikh, macd, mach, datt, th, manv, gia, coc);
        return mahd;
    }

    public static void UpdateHD_BLL(String diachikh, String macd, String tenkh) {
        HopDongDAL.UpdateHD_DAL(diachikh, macd, tenkh);
    }

    public static void UpdateHDMoney(HopDong hd, long soTien) {
        hd.setDaThanhToan(hd.getDaThanhToan() + soTien);
        DAL.HopDongDAL.UpdateHDMoney(hd);
    }

    public static HopDong findByID(String id) throws SQLException {
        return DAL.HopDongDAL.findByID(id);
    }

    public static boolean TimKiem_BLL(JTable tbl, String info) throws SQLException {
        List<HopDong> dsHopDongTK = HopDongDAL.TimKiem_DAL(info);
        if (dsHopDongTK.size() == 0) {
            return false;
        } else {
            LoadTable(tbl, dsHopDongTK);
            return true;
        }
    }

    public static long doanhThu() {
        long doanhThu = 0;
        try {
            List<CanHo> dsCanHo = DAL.ThongTinCanHoDAL.dsCanHoDaBan();

            long money = 0;
            for (CanHo dsCh : dsCanHo) {
                money = dsCh.getDaThanhToan();
                doanhThu += money;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HopDongBLL.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return doanhThu;
    }

    public static long tongGiaTriCH() {
        long doanhThu = 0;
        try {
            List<CanHo> dsCanHo = DAL.ThongTinCanHoDAL.dsCanHoDaBan();

            long money = 0;
            for (CanHo dsCh : dsCanHo) {
                money = dsCh.getGia();
                doanhThu += money;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HopDongBLL.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return doanhThu;
    }
}
