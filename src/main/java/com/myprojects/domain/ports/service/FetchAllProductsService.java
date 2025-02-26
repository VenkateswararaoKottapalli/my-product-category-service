package com.myprojects.domain.ports.service;

import com.myprojects.domain.ports.inbound.IFetchAllProducts;
import com.myprojects.domain.ports.outbound.IProductPort;
import com.myprojects.infrastructure.persistence.entity.ProductProjection;
import com.myprojects.interfaces.rest.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.myprojects.domain.ports.service.helper.ProductCategoryHelper.getProductResponseList;

@Service
@AllArgsConstructor
@Slf4j
public class FetchAllProductsService implements IFetchAllProducts {

    private final IProductPort fetchProductPort;

    @Override
    public List<ProductResponse> fetchAllProducts(String client, Integer pageNumber, Integer pageSize) {
        log.info("Started fetching all products");

        Page<ProductProjection> productProjections = fetchProductPort.fetchAllProducts(client,
                PageRequest.of(
                        pageNumber,
                        pageSize,
                        Sort.by(Sort.Direction.DESC, "price")
                                .and(Sort.by(Sort.Direction.ASC, "title")))
        );

        List<ProductResponse> productResponseList = getProductResponseList(productProjections);

        log.info("Fetched all products wirth size: {}", productResponseList.size());

        return productResponseList;
    }
}
