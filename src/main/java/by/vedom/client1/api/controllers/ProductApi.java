package by.vedom.client1.api.controllers;

import by.vedom.client1.api.model.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "product-api", url = "127.0.0.1:9966/products")
public interface ProductApi {

    @GetMapping("/{productId}")
    ResponseEntity<ProductDto> getProductById(UUID productId);

    @PostMapping
    ResponseEntity<ProductDto> saveNewProduct(@RequestBody @Validated ProductDto productDao);

    @PutMapping("/{productId}")
    ResponseEntity<ProductDto> updateProductById(@PathVariable("productId") UUID productId,
                                                                           @RequestBody @Validated ProductDto productDao);

    @GetMapping
    List<ProductDto> getAll();

}
