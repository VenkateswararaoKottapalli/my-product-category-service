package com.myprojects.domain.ports.service.helper;

import com.myprojects.infrastructure.persistence.entity.Product;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.request.CreateProductRequest;
import com.myprojects.interfaces.rest.request.ProductResponse;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryHelper {

    public static ProductResponse getProductResponse(ProductProjection productProjection) {
        ProductResponse productResponse = null;
        if (productProjection != null) {
            productResponse = new ProductResponse();
            productResponse.setId(productProjection.getId());
            productResponse.setTitle(productProjection.getTitle());
            productResponse.setDescription(productProjection.getDescription());
            productResponse.setPrice(productProjection.getPrice());
            productResponse.setCategory(productProjection.getCategory());
            productResponse.setImageUrl(productProjection.getImage());
        }
        return productResponse;
    }

    public static List<ProductResponse> getProductResponseList(List<ProductProjection> productProjectionList) {
        List<ProductResponse> productResponseList = new ArrayList<>();
        productProjectionList.stream()
                .forEach(productProjection ->
                        productResponseList.add(getProductResponse(productProjection))
                );
        return productResponseList;
    }

    public static Product createProduct(CreateProductRequest createProductRequest) {
        Product product = null;
        if (createProductRequest != null) {
            product = new Product();
            product.setTitle(createProductRequest.getTitle());
            product.setDescription(createProductRequest.getDescription());
            product.setPrice(createProductRequest.getPrice());
            product.setImage(createProductRequest.getImage());
        }
        return product;
    }

}
