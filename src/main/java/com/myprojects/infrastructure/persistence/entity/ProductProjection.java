package com.myprojects.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductProjection {
    private Integer id;
    private String title;
    private String description;
    private String category;
    private Double price;
    private String image;
}

