package com.shubham.Product.Exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ProduetException.class)
    public ResponseEntity<ErrorDto>  errorDtoResponseEntity(ProduetException produetException){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setCode(409);
        errorDto.setMessage(produetException.getMessage());
        return ResponseEntity.status(409).body(errorDto);
    }
  /*  @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<String>  errorDtoResponseEntity(Exception exception){

        return ResponseEntity.status(500).body("SOMETHING WENT WRONG");
    }
*/
    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class )
    public ResponseEntity<ErrorDto> cons(ConstraintViolationException constraintViolationException){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setMessage(constraintViolationException.getMessage());
        errorDto.setCode(409);
        return ResponseEntity.status(409).body(errorDto);
    }

}
