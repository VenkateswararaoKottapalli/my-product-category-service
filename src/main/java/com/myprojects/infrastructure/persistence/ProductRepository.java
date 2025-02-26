package com.myprojects.infrastructure.persistence;

import com.myprojects.infrastructure.persistence.entity.Product;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p.id, p.title, p.description, c.name, p.price, p.image " +
            "FROM product p " +
            "JOIN category c ON p.category_id = c.id " +
            "WHERE p.id = :id", nativeQuery = true)
    ProductProjection findProductById(@Param("id") Integer id);

    @Query(value = "SELECT p.id, p.title, p.description, c.name, p.price, p.image " +
            "FROM product p " +
            "JOIN category c ON p.category_id = c.id", nativeQuery = true)
    Page<ProductProjection> findAllProducts(PageRequest pageRequest);

    @Query("SELECT p FROM Product p WHERE p.id = :productId")
    Product fetchProductByProductId(Integer productId);

    @Query(value = "SELECT p.id, p.title, p.description, c.name, p.price, p.image " +
            "FROM product p " +
            "JOIN category c ON p.category_id = c.id " +
            "WHERE p.id = :id", nativeQuery = true)
    ProductProjection deleteProductById(@Param("id") Integer productId);
}






