package com.myprojects.domain.ports.service;

import com.myprojects.domain.ports.inbound.IFetchProduct;
import com.myprojects.interfaces.rest.request.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class FetchProductService implements IFetchProduct {

    @Override
    public ProductResponse fetchProduct(Integer productId) {
        return null;
    }
}