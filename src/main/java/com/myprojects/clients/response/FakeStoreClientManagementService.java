package com.myprojects.clients.response;

import com.myprojects.application.constant.CommonConstants;
import com.myprojects.clients.request.IClientManagementService;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.request.CreateProductRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class FakeStoreClientManagementService implements IClientManagementService {

    private final WebClient.Builder webClientBuilder;

    @Override
    public ProductProjection addNewProduct(CreateProductRequest createProductRequest) {
        log.info("Started creating product in FakeStore Client with request : {}", createProductRequest);
        Mono<ProductProjection> createProductResponseMono = webClientBuilder.build()
                .post()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL)
                .bodyValue(createProductRequest)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client create product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(ProductProjection.class);

        ProductProjection createProductResponse = null;
        if (!ObjectUtils.isEmpty(createProductResponseMono.block())) {
            createProductResponse = createProductResponseMono.block();
            log.info("Successfully created product in FakeStore Client with response  : {}", createProductResponse);
        }
        return createProductResponse;
    }

    @Override
    public ProductProjection deleteProduct(Integer productId) {
        log.info("Started deleting product in FakeStore Client with productId : {}", productId);
        Mono<ProductProjection> productResponseMono = webClientBuilder.build()
                .delete()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL + "/" + productId)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client delete product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(ProductProjection.class);
        ProductProjection productResponse = null;
        if (!ObjectUtils.isEmpty(productResponseMono.block())) {
            productResponse = productResponseMono.block();
            log.info("Deleted product successfully in FakeStore Client  with productId : {}", productId);
        }
        return productResponse;
    }

    @Override
    public Page<ProductProjection> fetchAllProducts(PageRequest pageRequest) {
        log.info("Started fetching all products in FakeStore Client");
        Mono<Page<ProductProjection>> productsList = webClientBuilder.build()
                .get()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client fetch all product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(new ParameterizedTypeReference<List<ProductProjection>>() {
                })
                .map(productProjections -> paginateProducts(productProjections, pageRequest));
        Page<ProductProjection> productResponseList = null;
        if (!ObjectUtils.isEmpty(productsList.block())) {
            productResponseList = productsList.block();
            log.info("Fetched all products in FakeStore Client with size: {}", productResponseList.getTotalElements());
        }
        return productResponseList;
    }

    @Override
    public ProductProjection fetchProduct(Integer productId) {
        log.info("Started fetching product in FakeStore Client with productId : {}", productId);
        Mono<ProductProjection> productResponseMono = webClientBuilder.build()
                .get()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL + "/" + productId)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client fetch product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(ProductProjection.class);

        ProductProjection productResponse = null;
        if (!ObjectUtils.isEmpty(productResponseMono.block())) {
            productResponse = productResponseMono.block();
            log.info("Fetched product successfully in FakeStore Client with productId : {}", productId);
        }
        return productResponse;
    }

    @Override
    public ProductProjection createOrUpdateProduct(Integer productId, CreateProductRequest createProductRequest) {
        log.info("Started creating or updating product in FakeStore Client with request : {}", createProductRequest);
        Mono<ProductProjection> productResponseMono = webClientBuilder.build()
                .put()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL + "/" + productId)
                .bodyValue(createProductRequest)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client create or update product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(ProductProjection.class);
        ProductProjection productResponse = null;
        if (!ObjectUtils.isEmpty(productResponseMono.block())) {
            productResponse = productResponseMono.block();
            log.info("Created or Updated product successfully in FakeStore Client with id : {}", productId);
        }
        return productResponse;
    }

    @Override
    public ProductProjection updateProduct(Integer productId, CreateProductRequest createProductRequest) {
        log.info("Started updating product in FakeStore Client with request : {}", createProductRequest);
        Mono<ProductProjection> productResponseMono = webClientBuilder.build()
                .patch()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL + "/" + productId)
                .bodyValue(createProductRequest)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client update product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(ProductProjection.class);
        ProductProjection productResponse = null;
        if (!ObjectUtils.isEmpty(productResponseMono.block())) {
            productResponse = productResponseMono.block();
            log.info("Updated product successfully in FakeStore Client with id : {}", productId);
        }
        return productResponse;
    }

    private Page<ProductProjection> paginateProducts(List<ProductProjection> products, PageRequest pageRequest) {
        int start = (pageRequest.getPageNumber()-1) * pageRequest.getPageSize();
        int end = Math.min((start + pageRequest.getPageSize()), products.size());

        List<ProductProjection> pagedProducts = products.subList(start, end);

        return new PageImpl<>(pagedProducts, pageRequest, products.size());
    }
}


