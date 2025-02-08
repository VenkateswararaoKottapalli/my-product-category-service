package com.myprojects.interfaces.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CreateProductResponse {
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}

