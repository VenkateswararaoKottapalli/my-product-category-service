package com.myprojects.domain.ports.service;

import com.myprojects.domain.ports.inbound.ICreateProduct;
import com.myprojects.domain.ports.outbound.ICreateProductPort;
import com.myprojects.domain.ports.outbound.IFetchCategoryPort;
import com.myprojects.infrastructure.persistence.entity.Product;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.request.CreateProductRequest;
import com.myprojects.interfaces.rest.request.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.myprojects.application.constant.CommonConstants.FAKE_STORE_CLIENT;
import static com.myprojects.domain.ports.service.helper.ProductCategoryHelper.getProductResponse;

@Service
@Slf4j
@AllArgsConstructor
public class CreateProductService implements ICreateProduct {

    private final ICreateProductPort createProductPort;
    private final IFetchCategoryPort fetchCategoryPort;

    @Override
    public ProductResponse addNewProduct(CreateProductRequest createProductRequest) {
        log.info("Started creating product with request: {}", createProductRequest);
        Product product = new Product();
        product.setTitle(createProductRequest.getTitle());
        product.setDescription(createProductRequest.getDescription());
        product.setPrice(createProductRequest.getPrice());
        product.setCategoryId(fetchCategoryPort.fetchCategoryId(createProductRequest.getCategory()));
        product.setImage(createProductRequest.getImage());
        ProductProjection productProjection = createProductPort.createProduct(createProductRequest,
                FAKE_STORE_CLIENT, product);
        ProductResponse addProductResponse = getProductResponse(productProjection);
        log.info("Completed creating product with response: {}", addProductResponse);
        return addProductResponse;
    }

}
