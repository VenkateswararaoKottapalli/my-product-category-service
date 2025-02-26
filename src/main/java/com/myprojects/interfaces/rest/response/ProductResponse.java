package com.myprojects.interfaces.rest.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse implements Serializable {
    private Integer id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
