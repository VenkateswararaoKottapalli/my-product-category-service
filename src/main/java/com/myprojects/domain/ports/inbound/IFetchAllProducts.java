package com.myprojects.domain.ports.inbound;

import com.myprojects.interfaces.rest.request.ProductResponse;

import java.util.List;

public interface IFetchAllProducts {
    List<ProductResponse> fetchAllProducts();
}
