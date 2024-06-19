package Model.DAO;

import Model.entities.Seller;
import java.util.List;

public interface SellerDAO {
    public void create( Seller sellerCreate );
    public void update( Seller sellerUpdate );
    public void delete( Integer id );
    public Seller findById( Integer id );
    public List<Seller> findAll();
}
