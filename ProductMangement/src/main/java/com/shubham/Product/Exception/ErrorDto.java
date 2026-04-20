package com.shubham.Product.Exception;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDto {
    private int code;
    private String message;
    private Date date= new Date(System.currentTimeMillis());

}
