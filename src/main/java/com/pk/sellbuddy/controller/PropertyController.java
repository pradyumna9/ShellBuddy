package com.pk.sellbuddy.controller;

import com.pk.sellbuddy.dto.Product;
import com.pk.sellbuddy.exception.ProductNotFoundException;
import com.pk.sellbuddy.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
public class PropertyController {

    private final ProductService productService;


    public PropertyController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/saveProduct")
    public void saveProduct(@RequestBody @Valid Product product){
        productService.saveProduct(product);
    }

    @GetMapping("/getProduct/{productId}")
    public Product getProductById(@PathVariable("productId") String productId){
        return productService.getProductById(productId).orElseThrow(()-> new ProductNotFoundException("Product Not Available"));
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable String productId){
        productService.deleteProductById(productId);
    }
}
