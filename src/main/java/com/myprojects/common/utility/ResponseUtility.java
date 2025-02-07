package com.myprojects.common.utility;

import com.myprojects.interfaces.rest.response.ResponseTemplate;
import com.myprojects.interfaces.rest.response.StatusResponse;

public class ResponseUtility {
    public static <T> ResponseTemplate<T> generateResponse(T responseData, Integer statusCode, String message) {
        return new ResponseTemplate<>(responseData, new StatusResponse(statusCode, message));
    }
}
