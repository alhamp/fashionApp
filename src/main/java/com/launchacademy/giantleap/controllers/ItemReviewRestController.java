package com.launchacademy.giantleap.controllers;

import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.FashionItemReview;
import com.launchacademy.giantleap.repositories.FashionItemReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemReviewRestController {
  private final FashionItemReviewRepository itemReviewRepository;

  @Autowired
  public ItemReviewRestController(FashionItemReviewRepository itemReviewRepository){
    this.itemReviewRepository = itemReviewRepository;
  }

  @GetMapping("api/v1/reviews/{id}")
  public Page<FashionItemReview> getFashionItems(@ModelAttribute FashionItem fashionItem, Pageable pageable){
    return itemReviewRepository.findAllByFashionItem(fashionItem, pageable);
  }

  @PostMapping("api/v1/reviews/")
  public FashionItemReview addReview(@RequestBody FashionItemReview itemReview){
    return itemReviewRepository.save(itemReview);
  }
}
