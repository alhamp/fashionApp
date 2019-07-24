package com.launchacademy.giantleap.controllers;

import java.awt.print.Pageable;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FashionItemRestController {

  public final FashionItemRepository fashionItemRepository;

  @Autowired
  public FashionItemRestController(FashionItemRepository fashionItemRepository){
    this.fashionItemRespository = fashionItemRepository;
  }

  @GetMapping("api/v1/fashion")
  public Page<FashionItem> getFashionItems(Pageable pageable){
    return fashionItemRepository.findAll(pageable);
  }

  @NoArgsConstructor
  private class FashionItemNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class FashionItemNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(FashionItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String fashionItemNotFoundHandler(FashionItemNotFoundException ex) {
      return ex.getMessage();
    }
  }

  @GetMapping("/api/v1/fashion/{id}")
  public FashionItem getOneItem(@PathVariable Integer id) {
    return fashionItemRespository.findById(id).orElseThrow(() -> new FashionItemNotFoundException());
  }
  @PostMapping("api/v1/fashion")
  public FashionItem newFashionItem(@RequestBody FashionItem fashionItem, Model model){
    return fashionItemRespository.save(fashionItem);
  }
}
