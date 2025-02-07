package com.myprojects.domain.ports.service;

import com.myprojects.domain.ports.inbound.ICreateCategory;
import com.myprojects.domain.ports.outbound.ISaveCategoryPort;
import com.myprojects.infrastructure.persistence.entity.Category;
import com.myprojects.interfaces.rest.request.CreateCategoryRequest;
import com.myprojects.interfaces.rest.response.CreateCategoryResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@AllArgsConstructor
@Slf4j
public class CreateCategoryService implements ICreateCategory {

    private final ISaveCategoryPort saveCategoryPort;

    @Override
    public CreateCategoryResponse createCategory(CreateCategoryRequest createCategoryRequest) {
        log.info("Started saving category with details {}.", createCategoryRequest);
        CreateCategoryResponse createCategoryResponse = null;
        if (!ObjectUtils.isEmpty(createCategoryRequest)) {
            Category category = new Category();
            category.setName(createCategoryRequest.getName());
            category.setDescription(createCategoryRequest.getDescription());
            Category savedCategory = saveCategoryPort.saveCategory(category);
            if (!ObjectUtils.isEmpty(savedCategory)) {
                createCategoryResponse = new CreateCategoryResponse(savedCategory.getName(), savedCategory.getDescription());
                log.info("Completed saving category with details {}.", createCategoryResponse);
            }
        }
        return createCategoryResponse;
    }
}
