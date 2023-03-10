package Products.Entity;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "product")
public class Product {

	@Id
	private String id; //when i add string as id it automatically provide id
	
	@NotNull(message = "Product name should not be null")
	private String name;
	
	@NotNull(message = "Category should not be null")
	private Category category;
	
	@Min(0)
	private double price;
	
	private String currency;
	
	@Max(100)
	@Min(0)
	private double discount;
		
	private String discountDescription;
	
    private List<String> imageURLs;
    
}


