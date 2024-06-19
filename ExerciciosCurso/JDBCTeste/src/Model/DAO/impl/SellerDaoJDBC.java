package Model.DAO.impl;

import Database.DB;
import Database.DbException;
import Model.DAO.SellerDAO;
import Model.entities.Department;
import Model.entities.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SellerDaoJDBC implements SellerDAO{

    private Connection conn;
    
    public SellerDaoJDBC( Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void create(Seller sellerCreate) {
        String insertQuery = "INSERT INTO Seller( name, email, birthDate, baseSalary, id_dep ) VALUES ( ?, ?, ?, ?, ? );";
        try( PreparedStatement ps = this.conn.prepareStatement(insertQuery)){
             conn.setAutoCommit( false );
            ps.setString( 1, sellerCreate.getName() );
            ps.setString( 2, sellerCreate.getEmail() );
            ps.setDate( 3, Date.valueOf( sellerCreate.getBirthDate() ) );
            ps.setDouble( 4, sellerCreate.getBaseSalary() );
            ps.setInt( 5, sellerCreate.getDepartament().getId() );
            if( ps.executeUpdate() != 0 ){
                System.out.println("Sucess!");
                conn.commit();
            }
        } catch (SQLException ex) {
            DB.rollBack();
            throw new DbException( ex.getMessage() );
        }
    }

    @Override
    public void update(Seller sellerUpdate) {
        String updateQuery = "UPDATE Seller SET "
                                                + "name = ?, "
                                                + "email = ?, "
                                                + "birthDate = ?, "
                                                + "baseSalary = ?, "
                                                + "id_dep = ? "
                                                + "WHERE id = ?";
        
        try( PreparedStatement ps = conn.prepareStatement( updateQuery ) ) {
            conn.setAutoCommit( false );
            ps.setString( 1, sellerUpdate.getName() );
            ps.setString( 2, sellerUpdate.getEmail() );
            ps.setDate( 3, Date.valueOf( sellerUpdate.getBirthDate()));
            ps.setDouble( 4, sellerUpdate.getBaseSalary() );
            ps.setInt( 5, sellerUpdate.getDepartament().getId() );
            ps.setInt( 6, sellerUpdate.getId() );
            if( ps.executeUpdate() != 0 ){
                System.out.println("Updated!");
                conn.commit();
            }
        } catch (SQLException ex) {
            DB.rollBack();
            throw new DbException( ex.getMessage() );
        }
    }

    @Override
    public void delete(Integer id) {
        String deleteQuery = "DELETE FROM Seller WHERE id = ?";
        
        try( PreparedStatement ps = conn.prepareStatement(deleteQuery)){
            ps.setInt( 1, id);
            if( ps.execute() ){
                System.out.println("Deleted!");
                conn.commit();
            }
        } catch (SQLException ex) {
            DB.rollBack();
            throw new DbException( ex.getMessage() );
        }
    }

    @Override
    public Seller findById(Integer id) {
        String selectQuery = "SELECT s.*, d.name AS dep_name FROM Seller s INNER JOIN Department d ON s.id_dep = d.id"
                + " WHERE s.id = ?;";
        
        try( PreparedStatement ps = conn.prepareStatement( selectQuery )){
            ps.setInt( 1, id);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                return instanceSeller( rs, instanceDepartment( rs ) );
            }
            return null;
        } catch (SQLException ex) {
            throw new DbException( ex.getMessage() );
        }
    }

    @Override
    public List<Seller> findAll() {
        String selectQuery = "SELECT s.*, d.name AS dep_name FROM Seller s INNER JOIN Department d ON s.id_dep = d.id;";
        
        try( PreparedStatement ps = conn.prepareStatement( selectQuery )){
            ResultSet rs = ps.executeQuery();
            List<Seller> sellers = new ArrayList<>();
            while( rs.next() ){
                sellers.add( instanceSeller( rs, instanceDepartment( rs ) )); 
            }
            return sellers;
        } catch (SQLException ex) {
            throw new DbException( ex.getMessage() );
        }
    }
    
    private Seller instanceSeller( ResultSet rs, Department dep ) throws SQLException{
        Seller seller = new Seller();
        seller.setId( rs.getInt( "id" ) );
        seller.setName( rs.getString( "name" ) );
        seller.setEmail( rs.getString( "email" ) );
        seller.setBirthDate( rs.getDate( "birthDate" ).toLocalDate() );
        seller.setBaseSalary( rs.getDouble( "baseSalary" ) );
        seller.setDepartament( dep );
        return seller;
    }
    
    private Department instanceDepartment( ResultSet rs ) throws SQLException{
        return new Department( rs.getInt("id_dep"), rs.getString("dep_name"));
    }
    
}
