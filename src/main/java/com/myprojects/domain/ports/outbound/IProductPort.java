package com.myprojects.domain.ports.outbound;

import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.infrastructure.persistence.entity.Product;

import java.util.List;

public interface IProductPort {
    ProductProjection fetchProductDetails(Integer productId, String clientName);

    List<ProductProjection> fetchAllProducts(String clientName);

    ProductProjection deleteProduct(Integer productId, String clientName);

    Product fetchProductById(Integer productId);
}
