package Program;

import Database.DB;
import Model.DAO.DaoFactory;
import Model.DAO.DepartmentDAO;
import Model.DAO.SellerDAO;
import Model.entities.Department;
import Model.entities.Seller;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        SellerDAO sellerDao = DaoFactory.createSellerDao();
        DepartmentDAO departmentDao = DaoFactory.createDepartmentDAO();
        
        Department dp = new Department( 1, "Development");
        Seller seller = new Seller(  1, "Luis", "luis@gmail.com", LocalDate.parse("2004-06-21"), 9200.00, dp  );
        seller.setName("Update");
        sellerDao.delete(seller.getId());
        for( Seller s : sellerDao.findAll() ){
            System.out.println( s.getId() + ": " + s.getName() );
        }
        DB.closeConnection();
        
        
//        String selectQuery = "select Nome, id_cat from produto WHERE id = ?";
//        Connection conn = DB.getConnection();
//        ResultSet rs = null;
//        try(PreparedStatement ps = conn.prepareStatement(selectQuery)) {
//            ps.setInt(1, 1);
//            rs = ps.executeQuery();
//            while( rs.next() ){
//                System.out.println( rs.getString( "Nome") + ": " +  rs.getInt("id_cat"));
//            }
//        } catch (DbException | SQLException e ) {
//            System.out.println( e.getMessage() );
//        }finally{
//            DB.closeConnection();
//            DB.closeResultSet( rs );
//        }
    }
}
