package com.myprojects.domain.ports.inbound;


import com.myprojects.interfaces.rest.request.AddProductRequest;
import com.myprojects.interfaces.rest.request.ProductResponse;

public interface IUpdateProduct {
    ProductResponse updateProduct(Integer productId, AddProductRequest addProductRequest);
}
