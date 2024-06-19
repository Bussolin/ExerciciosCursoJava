package Model.DAO;

import Database.DB;
import Model.DAO.impl.DepartmentDaoJDBC;
import Model.DAO.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDAO createSellerDao(){
        return new SellerDaoJDBC( DB.getConnection() );
    }
    
    public static DepartmentDAO createDepartmentDAO(){
        return new DepartmentDaoJDBC( DB.getConnection() );
    }
}
