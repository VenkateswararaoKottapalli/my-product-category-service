package com.myprojects.clients.request;

import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.request.CreateProductRequest;

import java.util.List;

public interface IClientManagementService {

    ProductProjection addNewProduct(CreateProductRequest addProductRequest);

    ProductProjection deleteProduct(Integer productId);

    List<ProductProjection> fetchAllProducts();

    ProductProjection fetchProduct(Integer productId);

    ProductProjection createOrUpdateProduct(Integer productId, CreateProductRequest addProductRequest);

    ProductProjection updateProduct(Integer productId, CreateProductRequest addProductRequest);

}
