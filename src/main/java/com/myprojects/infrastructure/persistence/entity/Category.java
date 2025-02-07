package com.myprojects.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import java.util.List;

import static com.myprojects.infrastructure.persistence.constant.CategoryConstant.*;

@Table(name = TABLE_NAME, schema = SCHEMA_NAME)
@Where(clause = "\"is_active\"=true")
@Getter
@Setter
@ToString
@Entity
public class Category extends Audit {

    @Column(name = NAME)
    private String name;

    @Column(name = DESCRIPTION)
    private String description;

    @OneToMany
    private List<Product> products;
}
