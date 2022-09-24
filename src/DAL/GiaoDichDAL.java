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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Vanh
 */
public class GiaoDichDAL {

    ArrayList<GiaoDich> list = new ArrayList<>();

    /**
     *
     * @return
     */
    public static ArrayList<GiaoDich> listGD() {
        ArrayList<GiaoDich> list = new ArrayList<>();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet r = s.executeQuery("SELECT GiaoDich.MaGiaoDich ,GiaoDich.NgayGiaoDich,GiaoDich.SoTien,GiaoDich.MaDotTT,DOTTHANHTOAN.MaHopDong, HOPDONG.MaCuDan, GiaoDich.MaNhanVien, NHANVIEN.HoTen FROM dbo.GIAODICH INNER JOIN DOTTHANHTOAN ON DOTTHANHTOAN.MaDot = GIAODICH.MaDotTT INNER JOIN NHANVIEN ON NHANVIEN.MaNhanVien =  GIAODICH.MaNhanVien INNER JOIN HOPDONG ON HOPDONG.MaHopDong = DOTTHANHTOAN.MaHopDong  ");
            while (r.next()) {
                GiaoDich gd = new GiaoDich();
                gd.setMaGiaoDich(r.getString("MaGiaoDich"));
                gd.setNgayGiaoDich(r.getLong("NgayGiaoDich"));
                gd.setSoTien(r.getLong("SoTien"));
                gd.setMaDotTT(r.getString("MaDotTT"));
                gd.setMaHopDong(r.getString("MaHopDong"));
                gd.setMaKhachHang(r.getString("MaCuDan"));
                gd.setMaNhanVien(r.getString("MaNhanVien"));
                gd.setTenNhanVien(r.getString("HoTen"));
                list.add(gd);
            }

        } catch (SQLException ex) {
            System.out.println("Message = " + ex.getMessage());
            return null;
        }

        return list;
    }

    public static boolean insert(GiaoDich gd) {

        try {
            PreparedStatement pre;

            pre = ConnectSQL.connect().prepareStatement("   INSERT INTO dbo.GIAODICH(MaGiaoDich, NgayGiaoDich, SoTien, MaDotTT, MaNhanVien) VALUES (?,?,?,?,?);");
            //MaGiaoDich, NgayGiaoDich, SoTien, MaDotTT,MaNhanVien

            pre.setString(1, gd.getMaGiaoDich());
            pre.setLong(2, gd.getNgayGiaoDich());
            pre.setLong(3, gd.getSoTien());
            pre.setString(4, gd.getMaDotTT());
            pre.setString(5, gd.getMaNhanVien());

            pre.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("ERROR IN Insert GiaoDichDAL " + e.getMessage());
            return false;
        }
    }

    public static void updateMoney(long soTien) throws SQLException {

        PreparedStatement updateDTTmoney;

        updateDTTmoney = ConnectSQL.connect().prepareStatement("UPDATE dbo.DOTTHANHTOAN SET SoTienDaTra = 100 WHERE MaDot = 'HD001.1';");

    }

    public static void getDTTMoney(String madtt) throws SQLException {
        Statement s = ConnectSQL.connect().createStatement();
        ResultSet r = s.executeQuery("S");
    }

    /**
     *
     * @param text
     * @return
     * @throws SQLException
     */
    public static ArrayList<GiaoDich> search(String text) throws SQLException, ParseException {
        ArrayList<GiaoDich> list = new ArrayList<>();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            //[MaGiaoDich],[NgayGiaoDich],[SoTien],[MaDotTT],[MaNhanVien]
            ResultSet r = s.executeQuery("  SELECT GiaoDich.MaGiaoDich ,GiaoDich.NgayGiaoDich,GiaoDich.SoTien,GiaoDich.MaDotTT,DOTTHANHTOAN.MaHopDong, HOPDONG.MaCuDan, GiaoDich.MaNhanVien, NHANVIEN.HoTen FROM dbo.GIAODICH INNER JOIN DOTTHANHTOAN ON DOTTHANHTOAN.MaDot = GIAODICH.MaDotTT INNER JOIN NHANVIEN ON NHANVIEN.MaNhanVien =  GIAODICH.MaNhanVien INNER JOIN HOPDONG ON HOPDONG.MaHopDong = DOTTHANHTOAN.MaHopDong\n" +
                "WHERE GiaoDich.MaGiaoDich LIKE '%"+text+"%'  OR GiaoDich.MaDotTT LIKE '%"+text+"%'   OR DOTTHANHTOAN.MaHopDong LIKE '%"+text+"%'   OR HOPDONG.MaCuDan LIKE '%"+text+"%'   OR GiaoDich.MaNhanVien LIKE '%"+text+"%'   OR NHANVIEN.HoTen LIKE '%"+text+"%'");
            while (r.next()) {
                GiaoDich gd = new GiaoDich();
                gd.setMaGiaoDich(r.getString("MaGiaoDich"));
                gd.setNgayGiaoDich(r.getLong("NgayGiaoDich"));
                gd.setSoTien(r.getLong("SoTien"));
                gd.setMaDotTT(r.getString("MaDotTT"));
                gd.setMaHopDong(r.getString("MaHopDong"));
                gd.setMaKhachHang(r.getString("MaCuDan"));
                gd.setMaNhanVien(r.getString("MaNhanVien"));
                gd.setTenNhanVien(r.getString("HoTen"));

                list.add(gd);
            }
        }catch(Exception e){
        
            System.out.println("Error in searchGD DAL "+ e.getMessage());}
        return list;
    }

    public static void main(String[] args) throws SQLException, ParseException {
        ArrayList<GiaoDich> search = search("NV001");
        for (int i = 0; i < search.size(); i++) {
            System.out.println(search.get(i).toString());
        }
    }

    public static boolean delete(String MSSV) {
        try {

            PreparedStatement pre = ConnectSQL.connect().prepareStatement("DELETE dbo.GiaoDich WHERE MSSV = ?");
            pre.setString(1, MSSV);
            return pre.executeUpdate() > 0;

        } catch (SQLException e) {
            return false;
        }
    }


}
