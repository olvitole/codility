package routeone;

import java.math.BigDecimal;
import java.util.Comparator;

public class Item {

	private String name;

	private BigDecimal price;

	private String desc;

	public Item(String name, BigDecimal price, String desc) {
		super();
		this.name = name;
		this.price = price;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", desc=" + desc + "]";
	}
	
	

}
