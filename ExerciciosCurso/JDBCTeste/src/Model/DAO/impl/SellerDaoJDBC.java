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
import java.time.LocalDate;
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
            ps.setString( 1, sellerCreate.getName() );
            ps.setString( 2, sellerCreate.getEmail() );
            ps.setDate( 3, Date.valueOf( sellerCreate.getBirthDate() ) );
            ps.setDouble( 4, sellerCreate.getBaseSalary() );
            ps.setInt( 5, sellerCreate.getDepartament().getId() );
            int rowsAffected = ps.executeUpdate();
            System.out.println( rowsAffected );
        } catch (SQLException ex) {
            throw new DbException( ex.getMessage() );
        }finally{
            DB.closeConnection();
        }
    }

    @Override
    public void update(Seller sellerUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Seller findById(Integer id) {
        String selectQuery = "SELECT s.*, d.name AS dep_name FROM Seller s INNER JOIN Department d ON s.id_dep = d.id"
                + " WHERE s.id = ?;";
        
        try( PreparedStatement ps = conn.prepareStatement( selectQuery )){
        ps.setInt( 1, id);
        ResultSet rs = ps.executeQuery();
        if( rs.next() ){
            Department dep = new Department( rs.getInt("id_dep"), rs.getString("dep_name"));
            Seller seller = new Seller();
            seller.setId( rs.getInt( "id" ) );
            seller.setName( rs.getString( "name" ) );
            seller.setEmail( rs.getString( "email" ) );
            seller.setBirthDate( rs.getDate( "birthDate" ).toLocalDate() );
            seller.setBaseSalary( rs.getDouble( "baseSalary" ) );
            seller.setDepartament( dep );
            return seller;
        }
        return null;
        } catch (SQLException ex) {
            throw new DbException( ex.getMessage() );
        }
    }

    @Override
    public List<Seller> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
