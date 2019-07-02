package a.springboot.circleci.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import a.springboot.circleci.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findByName(String name);
}
