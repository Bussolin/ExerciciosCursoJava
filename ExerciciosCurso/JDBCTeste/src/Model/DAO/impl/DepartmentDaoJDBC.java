package Model.DAO.impl;

import Database.DB;
import Database.DbException;
import Model.DAO.DepartmentDAO;
import Model.entities.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDAO {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }    
    
    @Override
    public void create(Department departmentCreate) {
        String insertQuery = "INSERT INTO Department( name ) VALUES ( ? );";
        Connection connection = DB.getConnection();
        
        try( PreparedStatement ps = connection.prepareStatement(insertQuery)){
            ps.setString( 1, departmentCreate.getName() );
            int rowsAffected = ps.executeUpdate();
            System.out.println( rowsAffected );
        } catch (SQLException ex) {
            throw new DbException( ex.getMessage() );
        }
    }

    @Override
    public void update(Department departmentUpdate) {
        String insertQuery = "UPDATE Department SET name = ?"
                                                + "WHERE id = ?;";
        Connection connection = DB.getConnection();
        
        try( PreparedStatement ps = connection.prepareStatement(insertQuery)){
            ps.setString( 1, departmentUpdate.getName() );
            ps.setInt(2, departmentUpdate.getId() );
            int rowsAffected = ps.executeUpdate();
            System.out.println( rowsAffected );
        } catch (SQLException ex) {
            throw new DbException( ex.getMessage() );
        }
    }

    @Override
    public void delete(Integer id) {
                String insertQuery = "DELETE FROM Department WHERE id = ?;";
        Connection connection = DB.getConnection();
        
        try( PreparedStatement ps = connection.prepareStatement(insertQuery)){
            ps.setInt(1, id );
            int rowsAffected = ps.executeUpdate();
            System.out.println( rowsAffected );
        } catch (SQLException ex) {
            throw new DbException( ex.getMessage() );
        }
    }

    @Override
    public Department findById(Integer id) {
        String selectQuery = "SELECT * FROM Department WHERE id = ?;";
        
        try( PreparedStatement ps = conn.prepareStatement( selectQuery )){
            ps.setInt( 1, id);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                Department dep = new Department( rs.getInt("id"), rs.getString("name"));
                return dep;
            }
            return null;
        } catch (SQLException ex) {
            throw new DbException( ex.getMessage() );
        }
    }

    @Override
    public List<Department> findAll() {
        String selectQuery = "SELECT * FROM Department;";
        
        try( PreparedStatement ps = conn.prepareStatement( selectQuery )){
            ResultSet rs = ps.executeQuery();
            List<Department> departments = new ArrayList<>();
            if( rs.next() ){
                departments.add( new Department( rs.getInt("id"), rs.getString("name")));
            }
            return departments;
        } catch (SQLException ex) {
            throw new DbException( ex.getMessage() );
        }
    }
    
}
