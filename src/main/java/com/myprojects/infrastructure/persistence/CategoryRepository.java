package com.myprojects.infrastructure.persistence;

import com.myprojects.infrastructure.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query("select c from Category c where c.name =: id")
    Category fetchByName(Integer id);


    Integer findCategoryIdByName(String name);
}
