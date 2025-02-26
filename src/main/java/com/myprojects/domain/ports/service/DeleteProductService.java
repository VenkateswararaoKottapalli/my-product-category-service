package com.myprojects.domain.ports.service;

import com.myprojects.domain.ports.inbound.IDeleteProduct;
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
public class DeleteProductService implements IDeleteProduct {

    private final IProductPort deleteProductPort;

    @Override
    public ProductResponse deleteProduct(Integer productId, String client) {
        log.info("Started deleting product with id: {}", productId);
        ProductProjection productProjection = deleteProductPort.deleteProduct(productId, client);
        ProductResponse productResponse = getProductResponse(productProjection);
        log.info("Deleted product successfully with id : {}", productId);
        return productResponse;
    }
}
