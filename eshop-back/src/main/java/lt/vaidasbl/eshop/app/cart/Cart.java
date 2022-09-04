package lt.vaidasbl.eshop.app.cart;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lt.vaidasbl.eshop.app.cartItem.CartItem;
import lt.vaidasbl.eshop.app.customer.Customer;
import lt.vaidasbl.eshop.app.item.Item;


@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy = "cart")
	private Customer customer;
	
	@ManyToMany
	@JoinTable(
	name = "cart_items", 
	joinColumns = @JoinColumn(name = "cart_id"),
	inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<CartItem> items;
	
	public Cart() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public void add(CartItem item) {
		items.add(item);
	}
	
	public boolean contains(Long itemid) {
		for (CartItem i : items) {
			if (i.getId() == itemid) return true;
		}
		
		return false;
	}
	
	public CartItem getItemById(Long itemid) {
		for (CartItem i : items) {
			if (i.getId() == itemid) return i;
		}
		
		return null;
	}

}
