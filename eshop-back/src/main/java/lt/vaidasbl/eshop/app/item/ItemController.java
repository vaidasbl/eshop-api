package lt.vaidasbl.eshop.app.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.vaidasbl.eshop.app.cartItem.CartItemService;
import lt.vaidasbl.eshop.app.commons.AddToCartRequest;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CartItemService cartItemService;

	@PostMapping("/saveone")
	public void saveItem(@RequestBody Item item) {
		itemService.saveItem(item);
	}
	
	@PostMapping("/savemultiple")
	public void saveMultipleItems(@RequestBody List<Item> items) {
		items.stream().forEach(i -> itemService.saveItem(i));
	}

	@GetMapping("/getall")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}

	@GetMapping("/getbyid/{id}")
	public Item getById(@PathVariable Long id) {
		return itemService.getById(id);
	}
	
	
	@PutMapping("/addtocart")
	public ResponseEntity<String> addItemToCart(@RequestBody AddToCartRequest req) {
		return cartItemService.addItemToCart(req.getCustomerid(), req.getItemid());
	}
}
