package Model.DAO;

import Model.DAO.impl.DepartmentDaoJDBC;
import Model.DAO.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDAO createSellerDao(){
        return new SellerDaoJDBC();
    }
    
    public static DepartmentDAO createDepartmentDAO(){
        return new DepartmentDaoJDBC();
    }
}
