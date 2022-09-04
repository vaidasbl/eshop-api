package lt.vaidasbl.eshop.app.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer findByUsername(String username);
	
	@Query("Select c from Customer c where c.username = :username AND c.password = :password")
	Customer login(@Param("username")String username, @Param("password") String password);
}
