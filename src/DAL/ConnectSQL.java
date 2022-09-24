package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanh
 */
public class ConnectSQL {

    public ConnectSQL() {
    }
   // jdbc:sqlserver://localhost:1433;
    private final static String URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyMuaBanCanHo1";
    private final static String USERNAME = "sa";
    private final static String PASSWORD = "0521";
    private static Connection conn = null;
    
    public static Connection connect(){
        try {
            conn = DriverManager.getConnection(URL,USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void close(){
        if(conn!=null) try {
            conn.close();
            conn = null;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
}
