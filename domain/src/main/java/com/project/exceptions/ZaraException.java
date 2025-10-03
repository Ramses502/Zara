package com.project.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ZaraException extends RuntimeException {

    private final ErrorCode code;
    private List<String> details;
    private final Object[] parameters;

    public ZaraException(ErrorCode code, Object... parameters) {
        this.code = code;
        this.parameters = parameters;
        this.details = new ArrayList<>();
    }
}
