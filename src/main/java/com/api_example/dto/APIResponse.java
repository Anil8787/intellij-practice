package com.api_example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponse <T>{
    private String message;
    private T data;
    private int status;

}
