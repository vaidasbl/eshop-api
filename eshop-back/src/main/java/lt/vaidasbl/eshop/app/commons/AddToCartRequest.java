package lt.vaidasbl.eshop.app.commons;

public class AddToCartRequest {

	private Long customerid;
	private Long itemid;
	

	public Long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	
	
}
