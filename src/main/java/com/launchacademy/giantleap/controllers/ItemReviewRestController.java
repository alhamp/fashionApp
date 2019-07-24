package com.launchacademy.giantleap.controllers;

import java.awt.print.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemReviewRestController {
  private final ItemReviewRepository itemReviewRepository;

  @Autowired
  public ItemReviewRestController(ItemReviewRepository itemReviewRepository){
    this.itemReviewRepository = itemReviewRepository;
  }

  @GetMapping("api/v1/reviews/{id}")
  public Page<ItemReview> getFashionItems(@ModelAttribute FashionItem fashionItem){ //Model Attribute or Request body?
    return itemReviewRepository.findAllByFashionItem(fashionItem);
  }

  @PostMapping("api/v1/reviews/{id}") //id in mapping or in hidden field?
  public ItemReview addReview(@RequestBody ItemReview itemReview){
    return itemReviewRepository.save(itemReview);
  }
}
