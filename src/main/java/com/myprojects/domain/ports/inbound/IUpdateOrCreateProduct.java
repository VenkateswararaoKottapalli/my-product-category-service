package com.myprojects.domain.ports.inbound;

import com.myprojects.interfaces.rest.request.CreateProductRequest;
import com.myprojects.interfaces.rest.response.ProductResponse;

public interface IUpdateOrCreateProduct {
    ProductResponse createOrUpdateProduct(Integer productId, CreateProductRequest addProductRequest, String client);
}
