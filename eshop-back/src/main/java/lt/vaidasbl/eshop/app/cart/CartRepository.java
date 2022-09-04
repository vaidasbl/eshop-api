package lt.vaidasbl.eshop.app.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lt.vaidasbl.eshop.app.item.Item;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{


}
