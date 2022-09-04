package lt.vaidasbl.eshop.app.cartItem;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lt.vaidasbl.eshop.app.cart.Cart;

@Entity
public class CartItem {

	@Id
	private Long id;
	private String name;
	private int quantity;
	
	public CartItem() {
		
	}
	
	public CartItem(Long id, String name, int quantity) {
		this.id = id;
		this.name = name;
		this.quantity = 1;
	}
	
	@ManyToMany(mappedBy = "items")
	private List<Cart> cart;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void addOneToQuantity() {
		this.quantity += 1; 
	}
	public void takeOneFromQuantity() {
		this.quantity -= 1; 
	}
	
	
	

	
}
