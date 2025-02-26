package com.myprojects.domain.ports.outbound;

import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.infrastructure.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IProductPort {
    ProductProjection fetchProductDetails(Integer productId, String clientName);

    Page<ProductProjection> fetchAllProducts(String clientName, PageRequest pageRequest);

    ProductProjection deleteProduct(Integer productId, String clientName);

    Product fetchProductById(Integer productId);

}
