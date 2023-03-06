package Products.Repositery;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import Products.Entity.Product;

@Repository
public interface ProductRepo extends MongoRepository<Product, Integer>{

	@Query("{'Category.name':?0}")
	List<Product> findByCategory(String category);

}
