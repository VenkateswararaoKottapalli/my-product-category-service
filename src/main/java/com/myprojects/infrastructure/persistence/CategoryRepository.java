package com.myprojects.infrastructure.persistence;

import com.myprojects.infrastructure.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select c from Category c where c.name =: id")
    Category fetchById(Integer id);

    @Query(value = "SELECT c.id FROM Category c WHERE LOWER(c.name) LIKE LOWER(:name)",
            nativeQuery = true)
    Integer findCategoryIdByName(String name);

    @Query(value = "SELECT c.name FROM Category c WHERE c.id =:id",
            nativeQuery = true)
    String fetchCategoryNameById(@Param("id") Integer categoryId);
}
