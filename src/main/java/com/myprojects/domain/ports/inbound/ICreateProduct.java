package com.myprojects.domain.ports.inbound;


import com.myprojects.interfaces.rest.request.AddProductRequest;
import com.myprojects.interfaces.rest.response.AddProductResponse;

public interface ICreateProduct {
    AddProductResponse addNewProduct(AddProductRequest addProductRequest);
}
