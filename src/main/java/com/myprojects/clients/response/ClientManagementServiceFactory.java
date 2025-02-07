package com.myprojects.clients.response;

import com.myprojects.clients.request.IClientManagementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ClientManagementServiceFactory {
    private final ApplicationContext applicationContext;
    private final String FAKE_STORE_CLIENT = "FakeStoreClient";
    private final String REAL_STORE_CLIENT = "RealStoreClient";

    public IClientManagementService getClientManagementServicePort(String clientName) {
        IClientManagementService fetchClientData = null;
        log.info("Identifying client service base on client name {}", clientName);
        if (FAKE_STORE_CLIENT.equalsIgnoreCase(clientName)) {
            log.info("Client service found for client name {}", clientName);
            fetchClientData = applicationContext.getBean(FakeStoreClientManagementService.class);
        } else {
            log.info("Client service not found for client name {}", clientName);
        }
        return fetchClientData;
    }
}