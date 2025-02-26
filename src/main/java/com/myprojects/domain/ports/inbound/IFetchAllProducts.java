package com.myprojects.domain.ports.inbound;

import com.myprojects.interfaces.rest.response.ProductResponse;

import java.util.List;

public interface IFetchAllProducts {
    List<ProductResponse> fetchAllProducts(String client, Integer pageNumber, Integer pageSize);
}
