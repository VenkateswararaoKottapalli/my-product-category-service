package com.myprojects.interfaces.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatusResponse {
    private Integer code;
    private String message;
}
