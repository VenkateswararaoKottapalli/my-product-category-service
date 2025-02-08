package com.myprojects.infrastructure.persistence;

import com.myprojects.infrastructure.persistence.entity.Product;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new com.myprojects.infrastructure.persistence.entity.ProductProjection(" +
            "p.id, p.title, p.description, p.category.name, p.price, p.image) " +
            "FROM Product p")
    ProductProjection saveProduct(Product product);

    ProductProjection findProductById(Integer id);

    @Query("SELECT new com.myprojects.infrastructure.persistence.entity.ProductProjection(" +
            "p.id, p.title, p.description, p.category.name, p.price, p.image) " +
            "FROM Product p")
    List<ProductProjection> findAllProducts();

    ProductProjection deleteProductById(Integer id);

    @Query("SELECT p FROM Product p WHERE p.id = :productId")
    Product fetchProductByProductId(Integer productId);
}






