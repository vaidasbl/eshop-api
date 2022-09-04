package lt.vaidasbl.eshop.app.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.vaidasbl.eshop.app.cartItem.CartItem;



@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@PostMapping("/new")
	public void createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
	}
	
	@PostMapping("/login")
	public CustomerDTO login(@RequestBody Customer customer) {
		return customerService.login(customer);
	}
	
	@GetMapping("/{customerid}/getitems")
	public List<CartItem> getCartItems(@PathVariable("customerid") Long customerid) {
		return customerService.getCartItems(customerid);
	}
	
}
