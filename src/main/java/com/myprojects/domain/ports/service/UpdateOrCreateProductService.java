package com.myprojects.domain.ports.service;

import com.myprojects.domain.ports.inbound.IUpdateOrCreateProduct;
import com.myprojects.domain.ports.outbound.ICreateProductPort;
import com.myprojects.domain.ports.outbound.IFetchCategoryPort;
import com.myprojects.domain.ports.outbound.IProductPort;
import com.myprojects.infrastructure.persistence.entity.Product;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.request.CreateProductRequest;
import com.myprojects.interfaces.rest.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import static com.myprojects.domain.ports.service.helper.ProductCategoryHelper.getProductResponse;

@Service
@Slf4j
@AllArgsConstructor
public class UpdateOrCreateProductService implements IUpdateOrCreateProduct {

    private final ICreateProductPort updateOrCreateProductPort;
    private final IProductPort productPort;
    private final IFetchCategoryPort fetchCategoryPort;

    @Override
    public ProductResponse createOrUpdateProduct(Integer productId, CreateProductRequest addProductRequest, String client) {
        log.info("Started updating or creating the product with id : {}", productId);
        ProductResponse productResponse = null;
        Product product = productPort.fetchProductById(productId);
        product = !ObjectUtils.isEmpty(product) ? product : new Product();
        product.setTitle(addProductRequest.getTitle());
        product.setDescription(addProductRequest.getDescription());
        product.setPrice(addProductRequest.getPrice());
        product.setCategoryId(fetchCategoryPort.fetchCategoryId(addProductRequest.getCategory()));
        product.setImage(addProductRequest.getImage());

        ProductProjection productProjection = updateOrCreateProductPort.updateProduct(productId, client,
                addProductRequest, product);
        productResponse = getProductResponse(productProjection);
        log.info("Updated or created product successfully with id : {}", productId);

        return productResponse;
    }
}
