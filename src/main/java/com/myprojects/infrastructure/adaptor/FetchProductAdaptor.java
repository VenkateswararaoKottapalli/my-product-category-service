package com.myprojects.infrastructure.adaptor;

import com.myprojects.clients.request.IClientManagementService;
import com.myprojects.domain.ports.outbound.IProductPort;
import com.myprojects.infrastructure.persistence.ProductRepository;
import com.myprojects.infrastructure.persistence.entity.Product;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.myprojects.application.constant.CommonConstants.FAKE_STORE_CLIENT;

@Component
@Slf4j
@AllArgsConstructor
public class FetchProductAdaptor implements IProductPort {

    private final IClientManagementService clientManagementService;
    private final ProductRepository productRepository;

    @Override
    public ProductProjection fetchProductDetails(Integer productId, String clientName) {
        log.info("Selecting client to fetch product with client name: {} and productId : {}", clientName, productId);
        ProductProjection productResponse = null;
        if (FAKE_STORE_CLIENT.equalsIgnoreCase(clientName)) {
            log.info("Choosing FakeStore client to get product.");
            productResponse = clientManagementService.fetchProduct(productId);
        } else {
            log.info("Choosing Real client to get product.");
            productResponse = productRepository.findProductById(productId);
        }
        return productResponse;
    }

    @Override
    public List<ProductProjection> fetchAllProducts(String clientName) {
        log.info("Selecting client to fetch all products with client name: {}", clientName);
        List<ProductProjection> productResponseList = null;
        if (FAKE_STORE_CLIENT.equalsIgnoreCase(clientName)) {
            log.info("Choosing FakeStore client to fetch all products.");
            productResponseList = clientManagementService.fetchAllProducts();
        } else {
            log.info("Choosing Real client to fetch all products.");
            productResponseList = productRepository.findAllProducts();
        }
        return productResponseList;
    }

    @Override
    public ProductProjection deleteProduct(Integer productId, String clientName) {
        log.info("Selecting client to delete product with client name: {} and productId : {}", clientName, productId);
        ProductProjection productResponse = null;
        if (FAKE_STORE_CLIENT.equalsIgnoreCase(clientName)) {
            log.info("Choosing FakeStore client to delete product.");
            productResponse = clientManagementService.deleteProduct(productId);
        } else {
            log.info("Choosing Real client to delete product.");
            productResponse = productRepository.deleteProductById(productId);
        }
        return productResponse;
    }

    @Override
    public Product fetchProductById(Integer productId) {
        log.info("Started fetching product with id: {}", productId);
        return productRepository.fetchProductByProductId(productId);
    }

}





