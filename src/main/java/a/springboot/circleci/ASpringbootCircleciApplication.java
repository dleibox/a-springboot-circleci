package a.springboot.circleci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import a.springboot.circleci.dao.ProductRepository;
import a.springboot.circleci.model.Product;

@SpringBootApplication
@RestController
public class ASpringbootCircleciApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ASpringbootCircleciApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ASpringbootCircleciApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ProductRepository repo) {
		return (args) -> {
			log.info("Initial DB");
			// save a couple of Persons
			repo.save(new Product("Product A"));
			repo.save(new Product("Product B"));
			repo.save(new Product("Product C"));

		};
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value = "/")
	public String hello() {
		return "Hello CircleCI";
	}

}
