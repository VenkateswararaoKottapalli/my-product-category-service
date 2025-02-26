package com.myprojects.domain.ports.outbound;

public interface IFetchCategoryPort {
    Integer fetchCategoryId(String categoryName);
    String fetchCategoryNameById(Integer categoryId);
}
