package com.myprojects.interfaces.rest.response;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
