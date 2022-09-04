package lt.vaidasbl.eshop.app.cartItem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lt.vaidasbl.eshop.app.cart.Cart;
import lt.vaidasbl.eshop.app.cart.CartRepository;
import lt.vaidasbl.eshop.app.customer.Customer;
import lt.vaidasbl.eshop.app.customer.CustomerRepository;
import lt.vaidasbl.eshop.app.item.Item;
import lt.vaidasbl.eshop.app.item.ItemRepository;

@Service
public class CartItemService {

	private CartItemRepository cartItemRepository;
	private ItemRepository itemRepository;
	private CartRepository cartRepository;
	private CustomerRepository customerRepository;
	
	public CartItemService(CartItemRepository cartItemRepository, ItemRepository itemRepository, CartRepository cartRepository, CustomerRepository customerRepository) {
		this.cartItemRepository = cartItemRepository;
		this.itemRepository = itemRepository;
		this.cartRepository = cartRepository;
		this.customerRepository = customerRepository;
	}
	
	
	public ResponseEntity<String> addItemToCart(Long customerid, Long itemid) {
		Item item = itemRepository.findById(itemid).orElse(null);
		Customer customer = customerRepository.findById(customerid).orElse(null);
		
		
		if (item == null || customer == null) {
			return new ResponseEntity<String>("customer or item not found", HttpStatus.BAD_REQUEST);
		}
		
		if (item.getStock() < 1) {
			return new ResponseEntity<String>("out of stock", HttpStatus.BAD_REQUEST);
		}
		
		 
			Cart cart = customer.getCart();
			
			if (cart.getItemById(item.getId()) == null) {
				CartItem cartItem = new CartItem(item.getId(), item.getName(), 1);
				cart.add(cartItem);
				cartItemRepository.save(cartItem);
				return new ResponseEntity<String>("item added", HttpStatus.ACCEPTED);
			}
			
			CartItem cartItem = cart.getItemById(item.getId());
			cartItem.addOneToQuantity();
			item.takeOneFromStock();
			cartItemRepository.save(cartItem);
			itemRepository.save(item);
			cartRepository.save(cart);
			
			return new ResponseEntity<String>("item added", HttpStatus.ACCEPTED);
		
	}
}
