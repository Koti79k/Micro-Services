package Products.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Products.Entity.Product;
import Products.Entity.ProductResponse;
import Products.Service.ProductService;

@RestController
@RequestMapping("/v1")
public class ProductController {

	@Autowired
	private ProductService pService;	
	
//	if you give same id it will not create and duplicate data also not created in MongoDB
	@PostMapping("/addProduct")
	ResponseEntity<ProductResponse> addProduct(@RequestBody @Valid Product product){
		ProductResponse productResponse = pService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
	}
	
	@GetMapping("/productList")
	List<Product> getListOfProducts(){
		return pService.listAllProducts();
	}
	
	@GetMapping("/productList/{category}")
	List<Product> getListOfProductsByCategory(@PathVariable String category){
		return pService.productCategoryList(category);
	}
	
	@GetMapping("/product/{id}")
	Product getProductsById(@PathVariable String id){
		return pService.productById(id);
	}
	
	//if you give same id it will update with that id. duplicate data also not created in MongoDB
	//If you give another id it will create another product entity
    @PutMapping("/productUpdate")
    ProductResponse updateProduct(@RequestBody Product product) {
        return pService.updateProduct(product);
    }
	
	@DeleteMapping("/product/{id}")
	Product deleteProductsById(@PathVariable String id){
		return pService.productById(id);
	}
}
