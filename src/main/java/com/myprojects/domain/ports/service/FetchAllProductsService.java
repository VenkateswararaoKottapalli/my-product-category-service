package com.myprojects.domain.ports.service;

import com.myprojects.domain.ports.inbound.IFetchAllProducts;
import com.myprojects.domain.ports.outbound.IProductPort;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.myprojects.domain.ports.service.helper.ProductCategoryHelper.getProductResponseList;

@Service
@AllArgsConstructor
@Slf4j
public class FetchAllProductsService implements IFetchAllProducts {

    private final IProductPort fetchProductPort;

    @Override
    public List<ProductResponse> fetchAllProducts(String client) {
        log.info("Started fetching all products");

        List<ProductProjection> productProjections = fetchProductPort.fetchAllProducts(client);

        List<ProductResponse> productResponseList = getProductResponseList(productProjections);

        log.info("Fetched all products wirth size: {}", productResponseList.size());

        return productResponseList;
    }
}
