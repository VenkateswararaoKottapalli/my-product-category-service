package com.myprojects.domain.ports.inbound;

import com.myprojects.interfaces.rest.request.AddProductRequest;
import com.myprojects.interfaces.rest.request.ProductResponse;

public interface IUpdateOrCreateProduct {
    ProductResponse updateOrProduct(Integer productId, AddProductRequest addProductRequest);
}
