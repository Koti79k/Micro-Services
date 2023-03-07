package Products.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Products.Entity.Product;
import Products.Entity.ProductResponse;
import Products.Exception.OfferNotValidException;
import Products.Exception.ProductNotFoundException;
import Products.Repositery.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo pRepo;
	
	
	public ProductResponse addProduct(Product product) {
		if(product.getPrice()==0 && product.getDiscount()>0) {
			throw new OfferNotValidException("No discount is allowed at 0 product price");
		}
		Product savedProduct =pRepo.save(product);
		return new ProductResponse("success",savedProduct.getName() + "added into the system");
	}
	
	public List<Product> listAllProducts(){		
		List<Product> L1= pRepo.findAll();
		  if (L1.isEmpty()) {
	            throw new ProductNotFoundException("No product found ");
	       }
		  return L1;
	}
	
	public List<Product> productCategoryList(String category){
		List<Product> productsByCategory = pRepo.findByCategory(category);
		if(productsByCategory.isEmpty()) {
			throw new ProductNotFoundException("No product found for the category-" + category);
		}
		return productsByCategory;
	}
	
	public Product productById(String id) {
		return pRepo.findById(id).orElseThrow(() -> new ProductNotFoundException
				                        ("Product not found for id - " + id));
	}
	
	public ProductResponse updateProduct(Product product) {
		Optional<Product> prod =pRepo.findById(product.getId());
		if(!prod.isPresent()) {
			return new ProductResponse("FAILED", "Product to be updated not found in the system");
		}
		Product updatedProduct = pRepo.save(product);
		return new ProductResponse("SUCCESS", "Product Updated - " + updatedProduct.getName());

	}
	
	public ProductResponse deleteProduct(String id) {
		Optional<Product> prod = pRepo.findById(id);
        if (!prod.isPresent()) {
            return new ProductResponse("FAILED", "Product to be deleted not found in the system");
        }
		pRepo.deleteById(id);
		return new ProductResponse("SUCCESS","produc deleted sucessfully");
	}
	
}
