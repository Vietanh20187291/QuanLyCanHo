package DAL;

import Entities.HopDong;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vanh
 */
public class HopDongDAL {

    public static List<HopDong> dsHopDong() throws SQLException {
        String query = "  select hd.MaHopDong,cd.TenCuDan,hd.MaCuDan,hd.MaCanHo,ch.Gia,hd.DaThanhToan,hd.NgayGiaoDich,hd.ThoiHan from HOPDONG hd inner join CANHO ch on hd.MaCanHo=ch.MaCanHo inner join CUDAN cd on hd.MaCuDan=cd.MaCuDan";
        ResultSet rs = ConnectSQL.connect().createStatement().executeQuery(query);
        List<HopDong> dsHopDong = new ArrayList<>();
        try {
            while (rs.next()) {
                HopDong hd = new HopDong();
                hd.setMaHopDong(rs.getString(1));
                hd.setTenKH(rs.getString(2));
                hd.setMaCuDan(rs.getString(3));
                hd.setMaCanHo(rs.getString(4));
                hd.setGia(rs.getLong(5));
                hd.setDaThanhToan(rs.getLong(6));
                hd.setNgayGiaoDich(rs.getString(7));
                hd.setThoiHan("" + rs.getDate(8));
                dsHopDong.add(hd);
            }
        } catch (SQLException e) {
            System.out.println("Error in ThongTinMuaBanDAL: " + e.getMessage());
        }
        return dsHopDong;
    }

    public static List<HopDong> dsHopDong1() throws SQLException {
        String query = "select * from HOPDONG";
        ResultSet rs = ConnectSQL.connect().createStatement().executeQuery(query);
        List<HopDong> dsHopDong = new ArrayList<>();
        try {
            while (rs.next()) {
                HopDong hd = new HopDong();
                hd.setMaHopDong(rs.getString(1));
                hd.setTenKH(rs.getString(2));
                hd.setMaCanHo(rs.getString(3));
                hd.setMaCuDan(rs.getString(4));
                hd.setDiaChiKhachHang(rs.getString(5));
                hd.setGia(rs.getLong(6));
                hd.setNgayGiaoDich(rs.getString(7));
                dsHopDong.add(hd);
            }
        } catch (SQLException e) {
            System.out.println("Error in ThongTinMuaBanDAL_1: " + e.getMessage());
        }
        return dsHopDong;
    }
    
    public static HopDong findByID(String id) throws SQLException{
            String query = "SELECT [MaHopDong],[NgayGiaoDich],[DiaChiKH],[MaCuDan],[MaCanHo],[DaThanhToan],[ThoiHan],[MaNhanVien],[Gia],[Coc] FROM [QuanLyCanHo].[dbo].[HOPDONG]"
                    + "WHERE MaHopDong = '"+id+"';";
        ResultSet r = ConnectSQL.connect().createStatement().executeQuery(query);
        HopDong hd = new HopDong();
        try {
            while (r.next()) {
//[MaHopDong],[NgayGiaoDich],[DiaChiKH],[MaCuDan],[MaCanHo],[DaThanhToan],[ThoiHan],[MaNhanVien],[Gia],[Coc] 
              //  dtt.setMaDot(r.getString("MaDot"));
              hd.setMaHopDong(r.getString("MaHopDong"));
              hd.setNgayGiaoDich(r.getString("NgayGiaoDich"));
              hd.setDiaChiKhachHang(r.getString("DiaChiKH"));
              hd.setMaCuDan(r.getString("MaCuDan"));
              hd.setMaCanHo(r.getString("MaCanHo"));
              hd.setDaThanhToan(r.getLong("DaThanhToan"));
              hd.setThoiHan(r.getString("ThoiHan"));
              hd.setMaNhanVien(r.getString("MaNhanVien"));
              hd.setGia(r.getLong("Gia"));
              hd.setCoc(r.getLong("Coc"));

            }
        } catch (SQLException e) {
            System.out.println("Error in findBYID HopDongDal: " + e.getMessage());
        }
        return hd;
    }

    public static void insertHD_DAL(String mahd, String ngaygd, String diachikh, String macd, String mach, long datt, String th, String manv, long gia, long coc) {
        try {
            //   INSERT INTO HOPDONG VALUES( 'HD0062','2021-11-03',N'Hà Nội', '111131','A71211',20000000,'2022-02-02','NV001',1900000000,20000000);
            String query = "INSERT INTO HOPDONG VALUES( '" + mahd + "','" + ngaygd + "',N'" + diachikh + "'," + macd + ",'" + mach + "'," + datt + ",'" + th + "','" + manv + "'," + gia + "," + coc + ");";

            ConnectSQL.connect().createStatement().executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error in insertHD_DAL: " + e.getMessage());
        }
    }

    public static void UpdateHD_DAL(String diachikh, String macd, String tenkh) {
        try {
            String query = "update HOPDONG set DiaChiKH=N'" + diachikh + "',TenCuDan=N'" + tenkh + "' where MaCuDan='" + macd + "'";
            ConnectSQL.connect().createStatement().executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error in insertHD_DAL: " + e.getMessage());
        }
    
    }
    public static void UpdateHDMoney(HopDong hd){
            try {
            String query = "UPDATE dbo.HOPDONG SET DaThanhToan = "+ hd.getDaThanhToan()+" WHERE MaHopDong = '"+hd.getMaHopDong()+"';";
            ConnectSQL.connect().createStatement().executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error in UpdateHDMoney_DAL: " + e.getMessage());
        }
    }


    public static List<HopDong> TimKiem_DAL(String info) throws SQLException {
        String query = "select distinct hd.MaHopDong,cd.TenCuDan,hd.MaCuDan,hd.MaCanHo,ch.Gia,hd.DaThanhToan,hd.NgayGiaoDich,hd.ThoiHan from HOPDONG hd join CANHO ch on hd.MaCanHo=ch.MaCanHo join CUDAN cd on hd.MaCuDan = cd.MaCuDan where hd.MaHopDong like '%" + info + "%' or hd.NgayGiaodich like '%" + info + "%'"
                + "or hd.DiaChiKH like '%" + info + "%' or hd.MaCuDan like '%" + info + "%' or hd.MaCanHo like '%" + info + "%' or cd.TenCuDan like N'%" + info + "%' or ch.Gia like '%" + info + "%'" + "or hd.DaThanhToan like'%" + info + "%'" + "or hd.ThoiHan like '%" + info + "%'";
        ResultSet rs = ConnectSQL.connect().createStatement().executeQuery(query);
        List<HopDong> dsHopDong = new ArrayList<>();
        try {
            while (rs.next()) {
                HopDong hd = new HopDong();
                hd.setMaHopDong(rs.getString(1));
                hd.setTenKH(rs.getString(2));
                hd.setMaCuDan(rs.getString(3));
                hd.setMaCanHo(rs.getString(4));
                hd.setGia(rs.getLong(5));
                hd.setDaThanhToan(rs.getLong(6));
                hd.setNgayGiaoDich(rs.getString(7));
                hd.setThoiHan("" + rs.getDate(8));
                dsHopDong.add(hd);
            }
        } catch (SQLException e) {
            System.out.println("Error in ThongTinMuaBanDAL: " + e.getMessage());
        }
        return dsHopDong;
    }
}
