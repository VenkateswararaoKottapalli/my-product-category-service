package com.myprojects.clients.request;

import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.request.CreateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IClientManagementService {

    ProductProjection addNewProduct(CreateProductRequest addProductRequest);

    ProductProjection deleteProduct(Integer productId);

    Page<ProductProjection> fetchAllProducts(PageRequest pageRequest);

    ProductProjection fetchProduct(Integer productId);

    ProductProjection createOrUpdateProduct(Integer productId, CreateProductRequest addProductRequest);

    ProductProjection updateProduct(Integer productId, CreateProductRequest addProductRequest);

}
