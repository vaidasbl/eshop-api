package lt.vaidasbl.eshop.app.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.vaidasbl.eshop.app.item.Item;

@RestController
@RequestMapping("/api/carts")
public class CartController {

	@Autowired
	private CartService cartService;
	

	
	
	
}
