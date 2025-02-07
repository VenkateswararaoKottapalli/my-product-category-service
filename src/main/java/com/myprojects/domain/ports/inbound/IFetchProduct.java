package com.myprojects.domain.ports.inbound;

import com.myprojects.interfaces.rest.request.ProductResponse;

public interface IFetchProduct {
    ProductResponse fetchProduct(Integer productId);
}
