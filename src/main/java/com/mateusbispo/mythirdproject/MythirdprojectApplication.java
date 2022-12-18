package com.mateusbispo.mythirdproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mateusbispo.mythirdproject.entities.Category;
import com.mateusbispo.mythirdproject.entities.Product;
import com.mateusbispo.mythirdproject.repositories.CategoryRepository;
import com.mateusbispo.mythirdproject.repositories.ProductRepository;

@SpringBootApplication
public class MythirdprojectApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MythirdprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");

		Product p1 = new Product(null, "Notebook Acer", 2200.00, cat1);
		Product p2 = new Product(null, "Clean Code", 120.00, cat2);
		Product p3 = new Product(null, "Playstation 5", 5500.00, cat1);
		Product p4 = new Product(null, "Docker and Kubernetes", 100.00, cat2);
		Product p5 = new Product(null, "Xbox Series X", 5999.90, cat1);
		Product p6 = new Product(null, "RTX-3080", 3000.00, cat1);
		Product p7 = new Product(null, "Geometria Analítica", 389.90, cat2);

		cat1.getProducts().addAll(Arrays.asList(p1, p3, p5, p6)); // MÉTODO addAll() ADICIONA VÁRIOS ELEMENTOS AO MESMO TEMPO
		cat2.getProducts().addAll(Arrays.asList(p2, p4, p7));
		
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
		productRepository.save(p5);
		productRepository.save(p6);
		productRepository.save(p7);
		
	}

}
