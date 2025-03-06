package com.pk.sellbuddy.service;

import com.pk.sellbuddy.dao.ProductRepo;
import com.pk.sellbuddy.dto.Product;
import com.pk.sellbuddy.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void saveProduct(Product product){
        ProductEntity productEntity = mapProductToProductEntity(product);
        productRepo.save(productEntity);
    }

    private ProductEntity mapProductToProductEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(product.getProductId());
        productEntity.setCost(product.getCost());
        productEntity.setName(product.getName());
        return productEntity;
    }

    private Product mapProductEntityToProduct(ProductEntity productEntity) {
        Product product = new Product();
        product.setProductId(productEntity.getProductId());
        product.setCost(productEntity.getCost());
        product.setName(productEntity.getName());
        return product;
    }

    public Optional<Product> getProductById(String productId){
        ProductEntity productEntity = productRepo.findProductByProductId(productId);
        return Optional.ofNullable(productEntity).map(this::mapProductEntityToProduct);
    }

    public void deleteProductById(String productId){
        ProductEntity productEntity = productRepo.findProductByProductId(productId);
        productRepo.delete(productEntity);
    }
}
