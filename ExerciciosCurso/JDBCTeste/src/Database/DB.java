package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DB {
    
    private static Connection conn = null;
    
    public static Connection getConnection() {
        if( conn == null ){
            try {
                Properties props = carregaProperties();
                String url = props.getProperty("dburl");
                System.out.println(url);
                conn = DriverManager.getConnection( url, props );
            } catch (SQLException ex) {
                throw new DbException( ex.getMessage() );
            }
        }
        return conn;
    }
    
    public static void closeConnection(){
        if( conn != null ){
            try{
                conn.close();
            }catch( SQLException ex){
                throw new DbException( ex.getMessage() );
            }
        }
    }
    
    public static void closeResultSet( ResultSet rs ){
        if( rs != null ){
            try{
                rs.close();
            }catch( SQLException ex){
                throw new DbException( ex.getMessage() );
            }
        }
    }
    
    private static Properties carregaProperties(){
        try( FileInputStream fs = new FileInputStream( "db.properties" ) ){
            Properties ps = new Properties();
            ps.load( fs );
            return ps;
        } catch (IOException ex) {
            throw new DbException( ex.getMessage() );
        }
    }
    
    public static void rollBack(){
        try {
            conn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
