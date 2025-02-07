package com.myprojects.infrastructure.adaptor;

import com.myprojects.clients.request.IClientManagementService;
import com.myprojects.domain.ports.outbound.IFetchProductPort;
import com.myprojects.infrastructure.persistence.ProductRepository;
import com.myprojects.interfaces.rest.request.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class FetchProductAdaptor implements IFetchProductPort {

    private final IClientManagementService clientManagementService;
    private final ProductRepository productRepository;

    @Override
    public ProductResponse fetchProductDetails(Integer productId, String clientName) {
        return null;
    }
}
