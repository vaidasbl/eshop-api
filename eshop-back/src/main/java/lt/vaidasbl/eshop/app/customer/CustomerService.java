package lt.vaidasbl.eshop.app.customer;


import java.util.List;

import org.springframework.stereotype.Service;

import lt.vaidasbl.eshop.app.cart.Cart;
import lt.vaidasbl.eshop.app.cart.CartRepository;
import lt.vaidasbl.eshop.app.cartItem.CartItem;

@Service
public class CustomerService {
	
	private CustomerRepository customerRepository;
	private CartRepository cartRepository;

	public CustomerService (CustomerRepository customerRepository, CartRepository cartRepository) {
		this.customerRepository = customerRepository;
		this.cartRepository = cartRepository;
	}
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public void createCustomer(Customer customer) {
		if (customerRepository.findByUsername(customer.getUsername()) != null)
			return;
		
		Cart c = new Cart();
		customer.setCart(c);
		
		cartRepository.save(c);
		customerRepository.save(customer);
	}

	public CustomerDTO login(Customer customer) {
		Customer exists = customerRepository.login(customer.getUsername(), customer.getPassword());
		CustomerDTO customerLogin = new CustomerDTO();
		
		if (exists == null) return null;
		
		customerLogin.setId(exists.getId());
		customerLogin.setUsername(exists.getUsername());
		customerLogin.setRole(exists.getRole());
		
		return customerLogin;
	}
	
	public List<CartItem> getCartItems(Long customerid){
		Customer customer = customerRepository.findById(customerid).orElse(null);
		
			if (customer != null) {
				return customer.getCart().getItems();
			}
		return null;
	}
	
}
