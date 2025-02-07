package com.myprojects.domain.ports.outbound;

import com.myprojects.infrastructure.persistence.entity.Category;

public interface ISaveCategoryPort {
    Category saveCategory(Category category);
}
