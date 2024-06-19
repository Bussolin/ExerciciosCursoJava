package Model.DAO.impl;

import Database.DB;
import Model.DAO.SellerDAO;
import Model.entities.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SellerDaoJDBC implements SellerDAO{

    @Override
    public void create(Seller sellerCreate) {
        String insertQuery = "INSERT INTO Seller( name, email, birthDate, baseSalary, id_dep ) VALUES ( ?, ?, ?, ?, ? );";
        Connection connection = DB.getConnection();
        
        try( PreparedStatement ps = connection.prepareStatement(insertQuery)){
            ps.setString( 1, sellerCreate.getName() );
            ps.setString( 2, sellerCreate.getEmail() );
            ps.setDate( 3, Date.valueOf( sellerCreate.getBirthDate()));
            ps.setDouble( 4, sellerCreate.getBaseSalary() );
            ps.setInt( 5, sellerCreate.getDepartament().getId() );
            int rowsAffected = ps.executeUpdate();
            System.out.println( rowsAffected );
        } catch (SQLException ex) {
            Logger.getLogger(SellerDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Seller> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
