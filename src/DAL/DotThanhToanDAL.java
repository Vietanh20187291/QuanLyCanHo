/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author Vanh
 */
public class DotThanhToanDAL {

    ArrayList<DotThanhToan> list = new ArrayList<>();

    /**
     *
     * @return
     */
    public static ArrayList<DotThanhToan> show() {
        ArrayList<DotThanhToan> list = new ArrayList<>();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet r = s.executeQuery("	SELECT DOTTHANHTOAN.MaDot, DOTTHANHTOAN.MaHopDong, DOTTHANHTOAN.DotSo, DOTTHANHTOAN.SoTienDuKien, DOTTHANHTOAN.SoTienDaTra, DOTTHANHTOAN.ThoiHan, HOPDONG.MaNhanVien, NHANVIEN.HoTen , HOPDONG.MaCuDan 	FROM [QuanLyCanHo].[dbo].[DOTTHANHTOAN]  INNER JOIN HOPDONG ON DOTTHANHTOAN.MaHopDong = HOPDONG.MaHopDong INNER JOIN NHANVIEN ON HOPDONG.MaNhanVien = NHANVIEN.MaNhanVien");
            while (r.next()) {
                DotThanhToan dtt = new DotThanhToan();
                dtt.setMaDot(r.getString("MaDot"));
                dtt.setMaHopDong(r.getString("MaHopDong"));
                dtt.setDotSo(r.getInt("DotSo"));
                dtt.setSoTienDuKien(r.getLong("SoTienDuKien"));
                dtt.setSoTienDaTra(r.getLong("SoTienDaTra"));
                dtt.setSoTienThieu(dtt.getSoTienDuKien() - dtt.getSoTienDaTra());
                dtt.setThoiHan(r.getLong("ThoiHan"));
                dtt.setMaNhanVien(r.getString("MaNhanVien"));
                dtt.setTenNhanVien(r.getString("HoTen"));
                dtt.setMaKhachHang(r.getString("MaCuDan"));
                list.add(dtt);

            }

        } catch (SQLException ex) {
            System.out.println("Message = " + ex.getMessage());
            return null;
        }

        return list;
    }

    public static void main(String[] args) {
        ArrayList<DotThanhToan> list = show();
        for (int i = 0; i < list.size(); i++) {
            try {
                long max = 20;
                long min = 1;
                long range = max - min + 1;
                           long rand = 10000000*((long)((Math.random() * range) + min));
                Statement s = ConnectSQL.connect().createStatement();
                ResultSet r = s.executeQuery("UPDATE [DOTTHANHTOAN] SET [SoTienDaTra]="+(list.get(i).getSoTienDuKien()-rand)+" WHERE MaDot = '" + list.get(i).getMaDot() + "';");
                r.next();

            } catch (SQLException ex) {
                System.out.println("Message = " + ex.getMessage());

            }
        }
    }

    public static ArrayList<DotThanhToan> search(String text) {
        ArrayList<DotThanhToan> list = new ArrayList<>();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet r = s.executeQuery("  SELECT DOTTHANHTOAN.MaDot, DOTTHANHTOAN.MaHopDong, DOTTHANHTOAN.DotSo, DOTTHANHTOAN.SoTienDuKien, DOTTHANHTOAN.SoTienDaTra, DOTTHANHTOAN.ThoiHan, HOPDONG.MaNhanVien, NHANVIEN.HoTen FROM [QuanLyCanHo].[dbo].[DOTTHANHTOAN] INNER JOIN HOPDONG ON DOTTHANHTOAN.MaHopDong = HOPDONG.MaHopDong INNER JOIN NHANVIEN ON HOPDONG.MaNhanVien = NHANVIEN.MaNhanVien WHERE DOTTHANHTOAN.MaDot LIKE '%" + text + "%'  OR DOTTHANHTOAN.MaHopDong LIKE '%" + text + "%'   OR DOTTHANHTOAN.DotSo LIKE '%" + text + "%'   OR DOTTHANHTOAN.SoTienDuKien LIKE '%" + text + "%'   OR DOTTHANHTOAN.SoTienDaTra LIKE '%" + text + "%'   OR HOPDONG.MaNhanVien LIKE '%" + text + "%'   OR DOTTHANHTOAN.ThoiHan LIKE '%" + text + "%'   OR NHANVIEN.HoTen LIKE '%" + text + "%'");
            while (r.next()) {
                DotThanhToan dtt = new DotThanhToan();
                dtt.setMaDot(r.getString("MaDot"));
                dtt.setMaHopDong(r.getString("MaHopDong"));
                dtt.setDotSo(r.getInt("DotSo"));
                dtt.setSoTienDuKien(r.getLong("SoTienDuKien"));
                dtt.setSoTienDaTra(r.getLong("SoTienDaTra"));
                dtt.setSoTienThieu(dtt.getSoTienDuKien() - dtt.getSoTienDaTra());
                dtt.setThoiHan(r.getLong("ThoiHan"));
                dtt.setMaNhanVien(r.getString("MaNhanVien"));
                dtt.setTenNhanVien(r.getString("HoTen"));
                list.add(dtt);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR IN SEARCH DTTDAL " + ex.getMessage());
            return null;
        }

        return list;
    }

    public static boolean insert(DotThanhToan dtt) {

        try {
            PreparedStatement pre;

            pre = ConnectSQL.connect().prepareStatement("  INSERT INTO dbo.DOTTHANHTOAN (MaDot, DotSo, SoTienDuKien, ThoiHan, SoTienDaTra, MaHopDong) VALUES (?,?,?,?,?,?);");
            pre.setString(1, dtt.getMaDot());
            pre.setInt(2, dtt.getDotSo());
            pre.setLong(3, dtt.getSoTienDuKien());
            pre.setLong(4, dtt.getThoiHan());
            pre.setLong(5, dtt.getSoTienDaTra());
            pre.setString(6, dtt.getMaHopDong());

            pre.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("ERROR IN Insert DTTDAL " + e.getMessage());
            return false;
        }
    }

    public static DotThanhToan findByID(String maDTT) {
        DotThanhToan dtt = new DotThanhToan();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet r = s.executeQuery("SELECT [MaDot],[DotSo],[SoTienDuKien],[ThoiHan],[SoTienDaTra],[MaHopDong] FROM [QuanLyCanHo].[dbo].[DOTTHANHTOAN] WHERE MaDot = '" + maDTT + "';");
            while (r.next()) {
                dtt.setMaDot(r.getString("MaDot"));
                dtt.setMaHopDong(r.getString("MaHopDong"));
                dtt.setDotSo(r.getInt("DotSo"));
                dtt.setSoTienDuKien(r.getLong("SoTienDuKien"));
                dtt.setSoTienDaTra(r.getLong("SoTienDaTra"));
                dtt.setSoTienThieu(dtt.getSoTienDuKien() - dtt.getSoTienDaTra());
                dtt.setThoiHan(r.getLong("ThoiHan"));
                dtt.setMaHopDong(r.getString("MaHopDong"));

            }

        } catch (SQLException ex) {
            System.out.println("ERROR IN SEARCH findByID DTTDAL " + ex.getMessage());
            return dtt;
        }

        return dtt;
    }

    public static void UpdateDTTMoney(DotThanhToan dtt) {
        try {
            String query = "UPDATE dbo.DOTTHANHTOAN SET SoTienDaTra = " + dtt.getSoTienDaTra() + " WHERE MaDot = '" + dtt.getMaDot() + "';";
            ConnectSQL.connect().createStatement().executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error in UpdateDTTMoney_DAL: " + e.getMessage());
        }
    }
    /**
     *
     * @param text
     * @return
     * @throws SQLException
     */

}
