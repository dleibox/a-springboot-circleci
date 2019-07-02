package a.springboot.circleci.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import a.springboot.circleci.dao.ProductRepository;
import a.springboot.circleci.model.Product;

@Service
@Qualifier("db")
public class ProductServiceImpl implements ProductService {

	private static Map<Long, Product> dict = new HashMap<>();
//	static {
//		Product honey = new Product();
//		honey.setId(1L);
//		honey.setName("Honey");
//		dict.put(honey.getId(), honey);
//
//		Product almond = new Product();
//		almond.setId(2L);
//		almond.setName("Almond");
//		dict.put(almond.getId(), almond);
//	}
	
	@Autowired
	ProductRepository dbRepo;

	@Override
	public void createProduct(Product product) {
		dict.put(product.getId(), product);
	}

	@Override
	public void updateProduct(Long id, Product product) {
		dict.remove(id);
		product.setId(id);
		dict.put(id, product);
	}

	@Override
	public void deleteProduct(Long id) {
		dict.remove(id);
	}

	@Override
	public Collection<Product> getProducts() {
//		return dict.values();
		return StreamSupport.stream(dbRepo.findAll().spliterator(), false).collect(Collectors.toList());
	}

}
