package Products.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	private Integer id;
	private String name;
	private Category category;
	private double price;
	private double discount;
	private double discountDescription;
}
