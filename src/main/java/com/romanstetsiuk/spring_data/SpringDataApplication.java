package com.romanstetsiuk.spring_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Product product = new Product();
        product.setName("Snickers");
        product.setDescription("chocolate");

        productRepository.save(product);

        Optional<Product> product1 = productRepository.findProductByName("Snickers");

        product1.ifPresent(System.out::println);

        List<Product> products = productRepository.fetchAllByName("Snickers");
        System.out.println("Size: " + products.size());

    }
}
