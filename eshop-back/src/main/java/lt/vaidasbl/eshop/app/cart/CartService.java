package lt.vaidasbl.eshop.app.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.vaidasbl.eshop.app.item.Item;

@Service
public class CartService {

	private CartRepository cartRepository;
	
	@Autowired
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	
}
