package com.myprojects.infrastructure.adaptor;

import com.myprojects.domain.ports.outbound.IFetchCategoryPort;
import com.myprojects.infrastructure.persistence.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class FetchCategoryAdaptor implements IFetchCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public Integer fetchCategoryId(String categoryName) {
        log.info("Started fetching category id for category name:{}", categoryName);

        return categoryRepository.findCategoryIdByName(categoryName);
    }

    @Override
    public String fetchCategoryNameById(Integer categoryId) {
        log.info("Started fetching category name for category id:{}", categoryId);
        return categoryRepository.fetchCategoryNameById(categoryId);
    }
}
