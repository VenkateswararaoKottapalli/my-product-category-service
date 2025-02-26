package com.myprojects.domain.ports.inbound;

import com.myprojects.interfaces.rest.response.ProductResponse;

public interface IFetchProduct {
    ProductResponse fetchProduct(Integer productId, String client);
}
