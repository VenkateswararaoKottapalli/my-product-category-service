package com.myprojects.infrastructure.adaptor;

import com.myprojects.clients.request.IClientManagementService;
import com.myprojects.domain.ports.outbound.ICreateProductPort;
import com.myprojects.domain.ports.outbound.IFetchCategoryPort;
import com.myprojects.infrastructure.persistence.ProductRepository;
import com.myprojects.infrastructure.persistence.entity.Product;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.request.CreateProductRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.myprojects.application.constant.CommonConstants.FAKE_STORE_CLIENT;
import static com.myprojects.domain.ports.service.helper.ProductCategoryHelper.getProductProjection;

@Component
@Slf4j
@AllArgsConstructor
public class CreateProductAdaptor implements ICreateProductPort {

    private final IClientManagementService clientManagementService;
    private final ProductRepository productRepository;
    private final IFetchCategoryPort fetchCategoryPort;

    @Override
    public ProductProjection createProduct(CreateProductRequest createProductRequest, String clientName, Product product) {
        log.info("Selecting client to create product with client name: {} and request : [{}]", clientName, createProductRequest);
        ProductProjection createProductResponse = null;
        if (FAKE_STORE_CLIENT.equalsIgnoreCase(clientName)) {
            log.info("Choosing FakeStore client to create a product");
            createProductResponse = clientManagementService.addNewProduct(createProductRequest);
        } else {
            log.info("Choosing Real client to create a product");
            Product createdProduct = productRepository.save(product);
            createProductResponse = getProductProjection(createdProduct);
            createProductResponse.setCategory(fetchCategoryPort.fetchCategoryNameById(product.getCategoryId()));
        }
        return createProductResponse;
    }

    @Override
    public ProductProjection updateProduct(Integer productId, String clientName, CreateProductRequest updateProductRequest, Product product) {
        log.info("Selecting client to update product with client name: {} and request : [{}]", clientName, updateProductRequest);
        ProductProjection createProductResponse = null;
        if (FAKE_STORE_CLIENT.equalsIgnoreCase(clientName)) {
            log.info("Choosing FakeStore client to create a product");
            createProductResponse = clientManagementService.updateProduct(productId, updateProductRequest);
        } else {
            log.info("Choosing Real client to create a product");
            Product createdProduct = productRepository.save(product);
            createProductResponse = getProductProjection(createdProduct);
        }
        return createProductResponse;
    }

    @Override
    public ProductProjection createOrUpdateProduct(Integer productId, String clientName, CreateProductRequest updateProductRequest, Product product) {
        log.info("Selecting client to create or update product with client name: {} and request : [{}]", clientName, updateProductRequest);
        ProductProjection createProductResponse = null;
        if (FAKE_STORE_CLIENT.equalsIgnoreCase(clientName)) {
            log.info("Choosing FakeStore client to create or update a product");
            createProductResponse = clientManagementService.createOrUpdateProduct(productId, updateProductRequest);
        } else {
            log.info("Choosing Real client to create or update a product");
            Product createdProduct = productRepository.save(product);
            createProductResponse = getProductProjection(createdProduct);
        }
        return createProductResponse;
    }
}
