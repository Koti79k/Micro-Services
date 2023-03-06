package Products.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Products.Entity.Product;
import Products.Repositery.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo pRepo;
	
	
	public String addProduct(Product product) {
		pRepo.save(product);
		return "success";
	}
	
	public List<Product> listAllProducts(){		
		return pRepo.findAll();
	}
	
	public List<Product> productCategoryList(String category){
		return pRepo.findByCategory(category);
	}
	
	public Product productById(Integer id) {
		return pRepo.findById(id).get(); //I added get() because it is optional
	}
	
	public String updateProduct(Product product) {
		pRepo.save(product);
		return "product updated successfully";

	}
	
	public String deleteProduct(Integer id) {
		pRepo.deleteById(id);
		return "produc deleted sucessfully";
	}
	
}
