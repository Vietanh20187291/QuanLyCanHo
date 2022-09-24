/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author vanh
 */
public class NhanVienDAL {

    private NhanVienDAL() {

    }

    public static Connection connection = ConnectSQL.connect();

    public static ArrayList<NhanVien> show(boolean vaiTro) {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet r = s.executeQuery("SELECT [HoTen],[DiaChi],[SDT],[Email],[MaNhanVien],[MatKhau],[VaiTro] FROM [QuanLyCanHo].[dbo].[NHANVIEN] WHERE VaiTro='" + vaiTro + "'");

            while (r.next()) {
                NhanVien nv = new NhanVien();

                nv.setMaNhanVien(r.getString("MaNhanVien"));
                nv.setHoTen(r.getString("HoTen"));
                nv.setDiaChi(r.getString("DiaChi"));
                nv.setSDT(r.getString("SDT"));
                nv.setEmail(r.getString("Email"));
                nv.setMatKhau(r.getString("MatKhau"));
                list.add(nv);
            }

        } catch (Exception ex) {
            System.out.println("Error in show tk" + ex.getMessage());
            return null;
        }

        return list;
    }
        public static NhanVien findByID(String id) {
                NhanVien nv = new NhanVien();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet r = s.executeQuery("SELECT [HoTen],[DiaChi],[SDT],[Email],[MaNhanVien],[MatKhau],[VaiTro] FROM [QuanLyCanHo].[dbo].[NHANVIEN] WHERE MaNhanVien='" + id + "'");

            while (r.next()) {

                nv.setMaNhanVien(r.getString("MaNhanVien"));
                nv.setHoTen(r.getString("HoTen"));
                nv.setDiaChi(r.getString("DiaChi"));
                nv.setSDT(r.getString("SDT"));
                nv.setEmail(r.getString("Email"));
                nv.setMatKhau(r.getString("MatKhau"));

            }

        } catch (Exception ex) {
            System.out.println("Error in findByID NV" + ex.getMessage());
            return null;
        }

        return nv;
    }

    public static NhanVien dangNhap(String userName, String passWord) {
        boolean vaiTro;
        NhanVien tk = null;
        try {
            String sql = "select * from NHANVIEN where MaNhanVien=? and MatKhau=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, userName);
            pre.setString(2, passWord);
            ResultSet result = pre.executeQuery();
            if (result.next()) {
                tk = new NhanVien();
                tk.setMaNhanVien(result.getString("MaNhanVien"));
                tk.setMatKhau(result.getString("MatKhau"));
                tk.setVaiTro(result.getBoolean("VaiTro"));
                tk.setDiaChi(result.getString("DiaChi"));
                tk.setEmail(result.getString("Email"));
                tk.setHoTen(result.getString("HoTen"));
                tk.setSDT(result.getString("SDT"));

                vaiTro = result.getBoolean("VaiTro");
            }

        } catch (Exception e) {
            System.out.println("Error in dangNhap TaiKhoanDAL " + e.getMessage());
        }
        return tk;
    }

    public static boolean insert(NhanVien nv) {

        try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement("  INSERT INTO [dbo].[NHANVIEN](MaNhanVien,MatKhau,HoTen,DiaChi,SDT,Email,VaiTro) VALUES (?, ?, ?, ?, ?, ?, ?)");
           //MaNhanVien,MatKhau,HoTen,DiaChi,SDT,Email,VaiTro
            pre.setString(1, nv.getMaNhanVien());
            pre.setString(2, nv.getMatKhau());
            pre.setString(3, nv.getHoTen());
            pre.setString(4, nv.getDiaChi());
            pre.setString(5, nv.getSDT());
            pre.setString(6, nv.getEmail());
            pre.setBoolean(7, false);
            pre.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    public static boolean update(String maNhanVien, String matKhau, boolean vaiTro) {
        try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement("UPDATE [QuanLyCanHo].[dbo].[NHANVIEN] "
                    + "SET MaNhanVien = ?,MatKhau =? WHERE VaiTro =?");
            pre.setString(1, maNhanVien);
            pre.setString(2, matKhau);
            pre.setBoolean(3, vaiTro);
            return pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }

    public static boolean update(String maNhanVien, String matKhau) {
        try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement("UPDATE [QuanLyCanHo].[dbo].[NHANVIEN] "
                    + "SET MatKhau =? WHERE MaNhanVien =?");
            pre.setString(2, maNhanVien);
            pre.setString(1, matKhau);
            return pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }

    public static boolean update(NhanVien nv) {
        try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement("  UPDATE dbo.NHANVIEN SET MatKhau = '"+nv.getMatKhau()+"', HoTen = N'"+nv.getHoTen()+"', DiaChi =N'"+nv.getDiaChi()+"', SDT='"+nv.getSDT()+"', Email ='"+nv.getEmail()+"',VaiTro = 0 WHERE MaNhanVien = '"+nv.getMaNhanVien()+"';");
            return pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error in UPdateNhanVienDAL "+ ex.getMessage());
            return false;
        }
    }

    public static boolean delete(String maNhanVien) {
        try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement("DELETE NHANVIEN WHERE MaNhanVien = ?");
            pre.setString(1, maNhanVien);
            return pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }

}
