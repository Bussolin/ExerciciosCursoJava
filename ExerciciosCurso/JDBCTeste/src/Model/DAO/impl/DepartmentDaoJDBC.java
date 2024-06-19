package Model.DAO.impl;

import Database.DB;
import Model.DAO.DepartmentDAO;
import Model.entities.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartmentDaoJDBC implements DepartmentDAO {

    @Override
    public void create(Department departmentCreate) {
        String insertQuery = "INSERT INTO Department( name ) VALUES ( ? );";
        Connection connection = DB.getConnection();
        
        try( PreparedStatement ps = connection.prepareStatement(insertQuery)){
            ps.setString( 1, departmentCreate.getName() );
            int rowsAffected = ps.executeUpdate();
            System.out.println( rowsAffected );
        } catch (SQLException ex) {
            Logger.getLogger(SellerDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DB.closeConnection();
        }
    }

    @Override
    public void update(Department departmentUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Department findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Department> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
