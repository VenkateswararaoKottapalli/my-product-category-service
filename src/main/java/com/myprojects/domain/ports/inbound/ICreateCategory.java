package com.myprojects.domain.ports.inbound;

import com.myprojects.interfaces.rest.request.CreateCategoryRequest;
import com.myprojects.interfaces.rest.response.CreateCategoryResponse;

public interface ICreateCategory {
    CreateCategoryResponse createCategory(CreateCategoryRequest createCategoryRequest);
}
