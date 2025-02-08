package com.myprojects.infrastructure.persistence.entity;

import com.myprojects.infrastructure.persistence.constant.AuditConstant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import static com.myprojects.infrastructure.persistence.constant.ProductConstant.*;

@Table(name = TABLE_NAME, schema = SCHEMA_NAME)
@Where(clause = "\"is_active\"=true")
@Getter
@Setter
@ToString
@Entity
public class Product extends Audit {

    @Column(name = NAME)
    private String title;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = PRICE)
    private Double price;

    @Column(name = CATEGORY_ID)
    private Integer categoryId;

    @Column(name = IMAGE_URL)
    private String image;

    @ManyToOne
    @JoinColumn(name = CATEGORY_ID, referencedColumnName = AuditConstant.ID, insertable = false, updatable = false)
    private Category category;



}
