/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DotThanhToanDAL;
import Entities.DotThanhToan;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Vanh
 */
public class DotThanhToanBLL {

    private DotThanhToanBLL() {

    }

    public static void show(JTable tbl) throws ParseException {

        List<DotThanhToan> dstt = DAL.DotThanhToanDAL.show();
        LoadTable(tbl, dstt);

    }

    public static void LoadTable(JTable tbl, List list) throws ParseException {
        List<DotThanhToan> dsDotThanhToan = list;
        Object[] colName = new Object[]{"STT", "Mã Đợt Thanh Toán", "Mã HĐ", "Đợt Số", "Khách Hàng" ,"Số Tiền Dự Kiến", "Đã Trả", "Còn Thiếu", "Thời Hạn", "NV Phụ Trách", "Phí Nộp Muộn"};
        Object[][] data = new Object[dsDotThanhToan.size()][colName.length];
        int row = 0;
        for (DotThanhToan c : dsDotThanhToan) {
            data[row][0] = (row + 1);
            data[row][1] = c.getMaDot();
            data[row][2] = c.getMaHopDong();
            data[row][3] = c.getDotSo();
            data[row][4] = c.getMaKhachHang();            
            data[row][5] = convertMoney(c.getSoTienDuKien());
            data[row][6] = convertMoney(c.getSoTienDaTra());
            data[row][7] = convertMoney(c.getSoTienDuKien() + getLateMoney(c) - c.getSoTienDaTra());
            data[row][8] = convertToDate(c.getThoiHan());
            data[row][9] = c.getMaNhanVien();
            data[row][10] = convertMoney(getLateMoney(c));
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
    public static void incommingDate(JTable tbl) throws ParseException {
        long month = 2678400000L;
        List<DotThanhToan> dsdtt = DAL.DotThanhToanDAL.show();
        List<DotThanhToan> list = new ArrayList<>();
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < dsdtt.size(); i++) {
            if (dsdtt.get(i).getThoiHan() > currentTime && dsdtt.get(i).getThoiHan() - currentTime < month) {
                list.add(dsdtt.get(i));

            }
        }
        for(int i = 0; i<list.size()-1; i++){
            if(list.get(i).getThoiHan()>list.get(i+1).getThoiHan()){
            DotThanhToan temp = list.get(i);
            list.set(i, list.get(i+1));
            list.set(i+1, temp);
            }
        }        
        
        LoadTable(tbl, list);

    }

    public static void lateDate(JTable tbl) {
        List<DotThanhToan> dsdtt = DAL.DotThanhToanDAL.show();
        List<DotThanhToan> list = new ArrayList<>();
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < dsdtt.size(); i++) {
            if (dsdtt.get(i).getThoiHan() < currentTime && dsdtt.get(i).getSoTienThieu()>0) {
                list.add(dsdtt.get(i));

            }
        }
        
        for(int i = 0; i<list.size()-1; i++){
            if(list.get(i).getThoiHan()>list.get(i+1).getThoiHan()){
            DotThanhToan temp = list.get(i);
            list.set(i, list.get(i+1));
            list.set(i+1, temp);
            }
        }
        try {
            LoadTable(tbl, list);
        } catch (ParseException ex) {
            Logger.getLogger(DotThanhToanBLL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static DotThanhToan findByID(String maDTT){
    return DAL.DotThanhToanDAL.findByID(maDTT);
    }

    public static void search(JTable tbl, String text) throws SQLException {

        ArrayList<DotThanhToan> list = DotThanhToanDAL.search(text);
        for(int i = 0; i<list.size();i++){
            System.out.println(list.get(i).toString());}
        try {
            LoadTable(tbl, list);
        } catch (ParseException ex) {
            Logger.getLogger(DotThanhToanBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //insert(DotThanhToan dtt)
    public static boolean insert(DotThanhToan dtt) {
        return DotThanhToanDAL.insert(dtt);
    }    
    

    public static String convertToDate(Long value) {
        Date date = new Date(value);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dateText = df.format(date);
        return dateText;
    }

    public static Long convertDateToLong(String string_date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date) formatter.parse(string_date);
        long mills = date.getTime();
        return mills;
    }
    
        public static void UpdateDTTMoney(DotThanhToan dtt, long soTien){
        dtt.setSoTienDaTra(dtt.getSoTienDaTra()+ soTien);
        DAL.DotThanhToanDAL.UpdateDTTMoney(dtt);
        }
        public static void main(String[] args) throws ParseException {
        DotThanhToan dtt = new DotThanhToan();
        dtt.setSoTienDuKien(1000);
        dtt.setSoTienDaTra(0);
            //System.out.println(convertDateToLong("29/02/2022"));
            dtt.setThoiHan(convertDateToLong("29/03/2022"));
            System.out.println(getLateMoney(dtt));
        //dtt.getThoiHan()
    }
        
    public static long getLateMoney(DotThanhToan dtt) throws ParseException {
        long month = 2678400000L;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String now = dtf.format(LocalDateTime.now());
        long today = convertDateToLong(now);
        long time = today - dtt.getThoiHan();
        if (time < month) {
            return 0;
        }
        else{
        long tienPhat = (long) (((long) (time/month))*(dtt.getSoTienDuKien()-dtt.getSoTienDaTra())*0.005);
        return tienPhat;
        }
    }
}
