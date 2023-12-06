package org.sid.inventoryservice1;

import org.sid.inventoryservice1.entities.Product;
import org.sid.inventoryservice1.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryService1Application {

    public static void main(String[] args) {
        SpringApplication.run(InventoryService1Application.class, args);}
        @Bean
         CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
             return args -> {
                 restConfiguration.exposeIdsFor(Product.class);
productRepository.saveAll(
        List.of(
                Product.builder().name("Computer").price(2000).quantity(15).build(),
                Product.builder().name("Playstation").price(6000).quantity(10).build(),
                Product.builder().name("Xbox").price(4500).quantity(20).build(),
                Product.builder().name("Smartphone").price(3500).quantity(35).build()
        )
);
             };

    }

}
