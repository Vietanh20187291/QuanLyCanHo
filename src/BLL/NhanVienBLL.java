/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.*;
import Entities.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableModel;

/**
 * @author vanh
 */
public class NhanVienBLL {

    private NhanVienBLL() {

    }

    public static boolean checkEmpty() {
        return NhanVienDAL.show(false).isEmpty();
    }

    public static TableModel show() {
        ArrayList<NhanVien> list = NhanVienDAL.show(false);
        //[MaNhanVien],[HoTen],[DiaChi],[SDT],[Email],[MaNhanVien],[MatKhau],[VaiTro]
        String[] colunmNames = {"Mã Nhân Viên ", "Họ Tên", "Địa Chỉ", "SĐT", "Email"};
        Object[][] data = new Object[list.size()][colunmNames.length];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getMaNhanVien();
            //        data[i][1] = list.get(i).getMatKhau();
            data[i][1] = list.get(i).getHoTen();
            data[i][2] = list.get(i).getDiaChi();
            data[i][3] = list.get(i).getSDT();
            data[i][4] = list.get(i).getEmail();
        }

        return new DefaultTableModel(data, colunmNames);
    }

    public static boolean checkAccountManager(String maNhanVien, String matKhau) {
        ArrayList<NhanVien> list = NhanVienDAL.show(true);
        return matKhau.equalsIgnoreCase(list.get(0).getMatKhau()) && maNhanVien.equalsIgnoreCase(list.get(0).getMaNhanVien());
    }

    public static boolean insert(NhanVien nv) {
        nv.setMatKhau("abc123");
        nv.setEmail(nv.getMaNhanVien().trim() + "@hust.com");
        return NhanVienDAL.insert(nv);
    }

    public static boolean update(String maNhanVien, String matKhau, boolean vaiTro) {
        return NhanVienDAL.update(maNhanVien, matKhau, vaiTro);

    }

    public static boolean update(String maNhanVien, String matKhau) {
        return NhanVienDAL.update(maNhanVien, matKhau);

    }

    public static boolean update(NhanVien nv) {
        nv.setEmail(nv.getMaNhanVien().trim() + "@hust.com");
        return DAL.NhanVienDAL.update(nv);
    }

    public static boolean delete(String maNhanVien) {
        return NhanVienDAL.delete(maNhanVien);
    }

    public static NhanVien findByID(String id) {
        return NhanVienDAL.findByID(id);
    }
}
