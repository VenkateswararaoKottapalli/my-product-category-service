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
    private String name;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = PRICE)
    private Boolean price;

    @ManyToOne
    @JoinColumn(name = CATEGORY_ID, referencedColumnName = AuditConstant.ID)
    private Category category;
}
