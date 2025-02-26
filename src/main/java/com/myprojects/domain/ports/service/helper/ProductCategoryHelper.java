package com.myprojects.domain.ports.service.helper;

import com.myprojects.domain.ports.outbound.IFetchCategoryPort;
import com.myprojects.infrastructure.persistence.entity.Product;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

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
            productResponse.setImage(productProjection.getImage());
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

    public static List<ProductResponse> getProductResponseList(Page<ProductProjection> productProjectionList) {
        List<ProductResponse> productResponseList = new ArrayList<>();
        productProjectionList.stream()
                .forEach(productProjection ->
                        productResponseList.add(getProductResponse(productProjection))
                );
        return productResponseList;
    }

    public static ProductProjection getProductProjection(Product product) {
        ProductProjection productProjection = null;
        if (product != null) {
            productProjection = new ProductProjection();
            productProjection.setId(product.getId());
            productProjection.setTitle(product.getTitle());
            productProjection.setDescription(product.getDescription());
            productProjection.setPrice(product.getPrice());
            productProjection.setImage(product.getImage());
        }
        return productProjection;
    }

}
