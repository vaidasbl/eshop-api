package lt.vaidasbl.eshop.app.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.vaidasbl.eshop.app.cart.Cart;
import lt.vaidasbl.eshop.app.cart.CartRepository;

@Service
public class ItemService {

	
	private ItemRepository itemRepository;
	private CartRepository cartRepository;
	
	public ItemService(ItemRepository itemRepository, CartRepository cartRepository) {
		this.itemRepository = itemRepository;
		this.cartRepository = cartRepository;
	}

	public void saveItem(Item item) {
		itemRepository.save(item);
	}

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	public Item getById(Long id) {
		return itemRepository.findById(id).orElse(null);
	}
	

	
}

