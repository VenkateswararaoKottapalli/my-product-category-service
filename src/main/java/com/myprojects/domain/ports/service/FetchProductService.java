package com.myprojects.domain.ports.service;

import com.myprojects.domain.ports.inbound.IFetchProduct;
import com.myprojects.domain.ports.outbound.IProductPort;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.myprojects.domain.ports.service.helper.ProductCategoryHelper.getProductResponse;

@Service
@Slf4j
@AllArgsConstructor
public class FetchProductService implements IFetchProduct {

    private final IProductPort fetchProductPort;

    @Override
    public ProductResponse fetchProduct(Integer productId, String client) {
        log.info("Started fetching product with id: {}", productId);
        ProductProjection productProjection = fetchProductPort.fetchProductDetails(productId, client);
        ProductResponse productResponse = getProductResponse(productProjection);
        log.info("Completed fetching product with response:[{}]", productResponse);
        return productResponse;
    }
}