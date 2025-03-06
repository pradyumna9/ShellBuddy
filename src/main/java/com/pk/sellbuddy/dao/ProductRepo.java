package com.pk.sellbuddy.dao;

import com.pk.sellbuddy.dto.Product;
import com.pk.sellbuddy.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,String>{

    public ProductEntity findProductByProductId(String productId);
}
