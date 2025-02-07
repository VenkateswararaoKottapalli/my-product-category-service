package com.myprojects.infrastructure.adaptor;

import com.myprojects.domain.ports.outbound.ISaveCategoryPort;
import com.myprojects.infrastructure.persistence.CategoryRepository;
import com.myprojects.infrastructure.persistence.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveCategoryAdaptor implements ISaveCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}