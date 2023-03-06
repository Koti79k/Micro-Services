package Products.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "product")
public class Product {

	@Id
	private Integer id;
	private String name;
	private Category category;
	private double price;
	private double discount;
	private String discountDescription;
}
