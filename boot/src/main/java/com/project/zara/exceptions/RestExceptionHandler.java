package com.project.zara.exceptions;


import com.project.exceptions.ZaraException;
import com.project.lib.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {

    private final MessagesService messagesService;

    @ExceptionHandler({ZaraException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<Map<String, String>> handleResourceNotFound(ZaraException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getParameters()[0].toString());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}