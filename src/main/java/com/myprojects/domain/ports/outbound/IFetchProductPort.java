package com.myprojects.domain.ports.outbound;

import com.myprojects.interfaces.rest.request.ProductResponse;

public interface IFetchProductPort {
 ProductResponse fetchProductDetails(Integer productId, String clientName);
}
