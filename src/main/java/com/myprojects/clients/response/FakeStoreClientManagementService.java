package com.myprojects.clients.response;

import com.myprojects.application.constant.CommonConstants;
import com.myprojects.clients.request.IClientManagementService;
import com.myprojects.interfaces.rest.request.AddProductRequest;
import com.myprojects.interfaces.rest.request.ProductResponse;
import com.myprojects.interfaces.rest.response.AddProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
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
    public AddProductResponse addNewProduct(AddProductRequest addProductRequest) {
        log.info("Started creating product in FakeStore Client with request : {}", addProductRequest);
        Mono<AddProductResponse> addProductResponseMono = webClientBuilder.build()
                .post()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL)
                .bodyValue(addProductRequest)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client create product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(AddProductResponse.class);

        AddProductResponse addProductResponse = null;
        if (!ObjectUtils.isEmpty(addProductResponseMono.block())) {
            addProductResponse = addProductResponseMono.block();
            log.info("Successfully created product in FakeStore Client with response  : {}", addProductResponse);
        }
        return addProductResponse;
    }

    @Override
    public ProductResponse deleteProduct(Integer productId) {
        log.info("Started deleting product in FakeStore Client with productId : {}", productId);
        Mono<ProductResponse> productResponseMono = webClientBuilder.build()
                .delete()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL + "/" + productId)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client delete product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(ProductResponse.class);
        ProductResponse productResponse = null;
        if (!ObjectUtils.isEmpty(productResponseMono.block())) {
            productResponse = productResponseMono.block();
            log.info("Deleted product successfully in FakeStore Client  with productId : {}", productId);
        }
        return productResponse;
    }

    @Override
    public List<ProductResponse> fetchAllProducts() {
        log.info("Started fetching all products in FakeStore Client");
        Mono<List<ProductResponse>> productsList = webClientBuilder.build()
                .get()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client fetch all product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(new ParameterizedTypeReference<List<ProductResponse>>() {

                });

        List<ProductResponse> productResponseList = null;
        if (!ObjectUtils.isEmpty(productsList.block())) {
            productResponseList = productsList.block();
            log.info("Fetched all products in FakeStore Client with size: {}", productResponseList.size());
        }
        return productResponseList;
    }

    @Override
    public ProductResponse fetchProduct(Integer productId) {
        log.info("Started fetching product in FakeStore Client with productId : {}", productId);
        Mono<ProductResponse> productResponseMono = webClientBuilder.build()
                .get()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL + "/" + productId)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client fetch product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(ProductResponse.class);

        ProductResponse productResponse = null;
        if (!ObjectUtils.isEmpty(productResponseMono.block())) {
            productResponse = productResponseMono.block();
            log.info("Fetched product successfully in FakeStore Client with productId : {}", productId);
        }
        return productResponse;
    }

    @Override
    public ProductResponse updateOrProduct(Integer productId, AddProductRequest addProductRequest) {
        log.info("Started creating or updating product in FakeStore Client with request : {}", addProductRequest);
        Mono<ProductResponse> productResponseMono = webClientBuilder.build()
                .put()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL + "/" + productId)
                .bodyValue(addProductRequest)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client create or update product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(ProductResponse.class);
        ProductResponse productResponse = null;
        if (!ObjectUtils.isEmpty(productResponseMono.block())) {
            productResponse = productResponseMono.block();
            log.info("Created or Updated product successfully in FakeStore Client with id : {}", productId);
        }
        return productResponse;
    }

    @Override
    public ProductResponse updateProduct(Integer productId, AddProductRequest addProductRequest) {
        log.info("Started updating product in FakeStore Client with request : {}", addProductRequest);
        Mono<ProductResponse> productResponseMono = webClientBuilder.build()
                .patch()
                .uri(CommonConstants.FAKE_STORE_CLIENT_API_URL + "/" + productId)
                .bodyValue(addProductRequest)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("FakeStore Client update product API call failed with status code: " + clientResponse.statusCode())))
                .bodyToMono(ProductResponse.class);
        ProductResponse productResponse = null;
        if (!ObjectUtils.isEmpty(productResponseMono.block())) {
            productResponse = productResponseMono.block();
            log.info("Updated product successfully in FakeStore Client with id : {}", productId);
        }
        return productResponse;
    }
}
