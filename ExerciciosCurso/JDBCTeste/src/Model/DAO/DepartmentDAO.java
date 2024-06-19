package Model.DAO;

import Model.entities.Department;
import java.util.List;

public interface DepartmentDAO {
    public void create( Department departmentCreate );
    public void update( Department departmentUpdate );
    public void delete( Integer id );
    public Department findById( Integer id );
    public List<Department> findAll();
}
