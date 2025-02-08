package com.myprojects.domain.ports.inbound;

import com.myprojects.interfaces.rest.request.CreateProductRequest;
import com.myprojects.interfaces.rest.request.ProductResponse;

public interface IUpdateOrCreateProduct {
    ProductResponse createOrUpdateProduct(Integer productId, CreateProductRequest addProductRequest);
}
