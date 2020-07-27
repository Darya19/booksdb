package com.epam.day8.controller.response;

import java.util.Optional;

public class ResponseHelper {

    public static <T> Response makeOkResponse(T result) {
        return new Response<>(Status.OK, "None", result);
    }

    public static Response makeErrorResponse(String errorMessage) {
        return new Response<>(Status.ERROR, errorMessage, Optional.empty());
    }
}
