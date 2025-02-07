package com.myprojects.clients.request;

import com.myprojects.interfaces.rest.request.AddProductRequest;
import com.myprojects.interfaces.rest.request.ProductResponse;
import com.myprojects.interfaces.rest.response.AddProductResponse;

import java.util.List;

public interface IClientManagementService {

    AddProductResponse addNewProduct(AddProductRequest addProductRequest);

    ProductResponse deleteProduct(Integer productId);

    List<ProductResponse> fetchAllProducts();

    ProductResponse fetchProduct(Integer productId);

    ProductResponse updateOrProduct(Integer productId, AddProductRequest addProductRequest);

    ProductResponse updateProduct(Integer productId, AddProductRequest addProductRequest);

}
