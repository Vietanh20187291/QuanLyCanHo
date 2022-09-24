/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import Entities.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author vanh
 */
public class KhuCanHoDAL {
  
    private KhuCanHoDAL() {
        
    }
        public static int phanTich(String MaKhu) {
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet x = s.executeQuery("SELECT MaKhu,COUNT(MaCanHo) AS SoCanHoTrong FROM dbo.CANHO WHERE TrangThai = 0 AND MaKhu = '"+MaKhu+"' GROUP BY MaKhu ;");
            int soCanHoTrong = 0;
            while(x.next()){
                soCanHoTrong = x.getInt("SoCanHoTrong");
            }
            return soCanHoTrong;
        } catch (SQLException e) {
            System.out.println("Failed phanTich : "+e.getMessage());
        }
        return 0;

    }

    public static ArrayList<KhuCanHo> showPhanTich() {
        ArrayList<KhuCanHo> list = new ArrayList<>();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet r = s.executeQuery(" SELECT * FROM KHUCANHO");

            while (r.next()) {
                KhuCanHo c = new KhuCanHo();
                c.setMaKhu(r.getString("MaKhu"));
                c.setTenKhu(r.getString("TenKhu"));
                c.setSoTang(r.getInt("SoTang"));
                c.setSoCanTT(r.getInt("SoCanTT"));
                c.setSoCanTrong(phanTich(c.getMaKhu()));

                list.add(c);
            }

        } catch (SQLException ex) {
            return null;
        }

        return list;
    }
    public static ArrayList<KhuCanHo> show(){
        
        ArrayList<KhuCanHo> list = new ArrayList<>();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet r =  s.executeQuery("SELECT * FROM KHUCANHO");
        
            while (r.next()){
                list.add(new KhuCanHo(r.getString(1), r.getString(2), r.getInt(3), r.getInt(4), r.getString(5)));
            }   
            
        } catch (SQLException ex) {
            return null;
        }
        
        Collections.sort(list,(x,y)->{
            return x.getMaKhu().compareTo(y.getMaKhu());
        });
        
        return list;
    }
    
    public static boolean insert(KhuCanHo khu){  
         try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement
            ("INSERT INTO [dbo].[KHUCANHO] VALUES (?, N'"+khu.getTenKhu()+"', ?, ?, ?)");
              pre.setString(1, khu.getMaKhu());
              pre.setInt(2, khu.getSoTang());
              pre.setInt(3, khu.getSoCanTT());
              pre.setString(4,khu.getDiaChi());
              pre.executeUpdate();
              
              return true;
              
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static boolean update(String maKhu,String tenKhu,String diaChi){
           try {
               
               PreparedStatement pre = ConnectSQL.connect().prepareStatement
                    ("UPDATE dbo.KHUCANHO SET TenKhu = N'"+tenKhu+"',DiaChi = ? WHERE MaKhu = ?");
                pre.setString(1, diaChi);
                pre.setString(2, maKhu);
            return pre.executeUpdate() > 0;
            
        } catch(SQLException e){
            return false;
        }
    }
    
    public static boolean delete(String maKhu){
           try {
               
            PreparedStatement pre = ConnectSQL.connect().prepareStatement
                ("DELETE dbo.KHUCANHO WHERE MaKhu = ?");
                pre.setString(1, maKhu);
            return pre.executeUpdate() > 0;
            
        } catch(SQLException e){
            return false;
        }
    }    
    
    public static ArrayList<KhuCanHo> search(String text) throws SQLException{
        
        Statement s  = ConnectSQL.connect().createStatement();
        ResultSet r = s.executeQuery("SELECT * FROM dbo.KHUCANHO WHERE "
        + "MaKhu LIKE '%"+text+"%' OR TenKhu LIKE N'%"+text+"%' OR SoTang LIKE '%"+text+"%' OR SoCanTT LIKE '%"+text+"%' OR DiaChi LIKE N'%"+text+"%'");
        ArrayList<KhuCanHo> list = new ArrayList<>();
        while(r.next()){
             list.add(new KhuCanHo(r.getString(1), r.getString(2), r.getInt(3), r.getInt(4), r.getString(5)));
        }
        return list;
    }
    
}
