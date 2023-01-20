package com.spring.testproject.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SpringBootExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(SpringBootExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
        HttpHeaders resHttpHeaders = new HttpHeaders();
        //resHttpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        LOGGER.info(e.getMessage());
        LOGGER.info("Advice 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("massage", "에러 발생");

        return new ResponseEntity<>(map, resHttpHeaders, httpStatus);
    }
}
