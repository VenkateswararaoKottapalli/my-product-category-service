package com.myprojects.domain.ports.service;

import com.myprojects.domain.ports.inbound.IUpdateProduct;
import com.myprojects.domain.ports.outbound.ICreateProductPort;
import com.myprojects.domain.ports.outbound.IFetchCategoryPort;
import com.myprojects.domain.ports.outbound.IProductPort;
import com.myprojects.infrastructure.persistence.entity.Product;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.request.CreateProductRequest;
import com.myprojects.interfaces.rest.request.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import static com.myprojects.application.constant.CommonConstants.FAKE_STORE_CLIENT;
import static com.myprojects.domain.ports.service.helper.ProductCategoryHelper.getProductResponse;

@Service
@Slf4j
@AllArgsConstructor
public class UpdateProductService implements IUpdateProduct {

    private final ICreateProductPort createProductPort;
    private final IProductPort productPort;
    private final IFetchCategoryPort fetchCategoryPort;

    @Override
    public ProductResponse updateProduct(Integer productId, CreateProductRequest createProductRequest) {
        log.info("Started updating the product with id : {}", productId);
        ProductResponse productResponse = null;
        if (!ObjectUtils.isEmpty(productId)) {
            Product product = productPort.fetchProductById(productId);
            if (!ObjectUtils.isEmpty(product)) {
                product.setTitle(createProductRequest.getTitle());
                product.setDescription(createProductRequest.getDescription());
                product.setPrice(createProductRequest.getPrice());
                product.setCategoryId(fetchCategoryPort.fetchCategoryId(createProductRequest.getCategory()));
                product.setImage(createProductRequest.getImage());
            }
            ProductProjection productProjection = createProductPort.updateProduct(productId, FAKE_STORE_CLIENT,
                    createProductRequest, product);
            productResponse = getProductResponse(productProjection);
            log.info("Completed updating product with response: {}", productResponse);
        }else{
            log.info("Product id is empty");
        }
        return productResponse;
    }
}
