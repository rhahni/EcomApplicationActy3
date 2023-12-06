package org.sid.billingservice.services;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service1")
public interface ProductRestClient {
    @GetMapping(path = "products/{id}")
     Product findProductById(@PathVariable Long id);
    @GetMapping("/products")
     PagedModel<Product> allProducts();
}
