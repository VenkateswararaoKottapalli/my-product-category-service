package com.myprojects.domain.ports.inbound;

import com.myprojects.interfaces.rest.response.ProductResponse;

public interface IDeleteProduct {
    ProductResponse deleteProduct(Integer productId, String client);
}
