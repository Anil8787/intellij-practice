package com.api_example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.*;


@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Map<String,Object>> handleResponseNotFound(ResourceNotFound ex , WebRequest request) {
       Map<String, Object> response = new HashMap<>();
       response.put("timeStamp", LocalDateTime.now());
       response.put("message", ex.getMessage());
       response.put("error",HttpStatus.NOT_FOUND.getReasonPhrase());
       response.put("url",request.getDescription(false));
       response.put("status", HttpStatus.NOT_FOUND.value());
       return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
   }


   @ExceptionHandler(Exception.class)
   public ResponseEntity<Map<String,Object>> handleGlobalException(Exception ex, WebRequest request){
       Map<String,Object> response = new HashMap<>();
       response.put("timeStamp",LocalDateTime.now());
       response.put("message",ex.getMessage());
       response.put("error",HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
       response.put("url",request.getDescription(false));
       response.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
       return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
   }





}













