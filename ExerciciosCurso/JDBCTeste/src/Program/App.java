package Program;

import Database.DB;
import Database.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String selectQuery = "select Nome, id_cat from produto WHERE id = ?";
        Connection conn = DB.getConnection();
        ResultSet rs = null;
        try(PreparedStatement ps = conn.prepareStatement(selectQuery)) {
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while( rs.next() ){
                System.out.println( rs.getString( "Nome") + ": " +  rs.getInt("id_cat"));
            }
        } catch (DbException | SQLException e ) {
            System.out.println( e.getMessage() );
        }finally{
            DB.closeConnection();
            DB.closeResultSet( rs );
        }
    }
    
}
