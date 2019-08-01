package com.launchacademy.giantleap.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FashionItemNotFoundAdvice {
  @ResponseBody
  @ExceptionHandler(FashionItemNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String fashionItemNotFoundHandler(FashionItemNotFoundException ex) {
    return ex.getMessage();
  }
}