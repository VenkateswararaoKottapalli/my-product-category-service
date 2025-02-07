package com.myprojects.interfaces.rest.response;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryResponse {
    private String name;
    private String description;
}
