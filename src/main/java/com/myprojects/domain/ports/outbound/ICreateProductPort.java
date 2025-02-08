package com.myprojects.domain.ports.outbound;

import com.myprojects.infrastructure.persistence.entity.Product;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.request.CreateProductRequest;

public interface ICreateProductPort {
    ProductProjection createProduct(CreateProductRequest addProductRequest, String clientName, Product product);

    ProductProjection updateProduct(Integer productId, String clientName, CreateProductRequest updateProductRequest, Product product);

    ProductProjection createOrUpdateProduct(Integer productId, String clientName, CreateProductRequest updateProductRequest, Product product);
}
