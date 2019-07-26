package com.launchacademy.giantleap.controllers;

import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.FashionItemReview;
import com.launchacademy.giantleap.repositories.FashionItemRepository;
import com.launchacademy.giantleap.repositories.ItemReviewRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemReviewRestController {
  private final ItemReviewRepository itemReviewRepository;
  private final FashionItemRepository fashionItemRepository;

  @Autowired
  public ItemReviewRestController(ItemReviewRepository itemReviewRepository, FashionItemRepository fashionItemRepository){
    this.itemReviewRepository = itemReviewRepository;
    this.fashionItemRepository = fashionItemRepository;
  }

  @GetMapping("api/v1/reviews/{id}")
  public Page<FashionItemReview> getFashionItems(@RequestAttribute Integer id, Pageable pageable){
    Optional<FashionItem> fashionItem = fashionItemRepository.findById(id);
    return itemReviewRepository.findAllByFashionItem(fashionItem, pageable);
  }

  @PostMapping("api/v1/reviews/")
  public FashionItemReview addReview(@RequestBody FashionItemReview itemReview){
    System.out.println(itemReview.toString());
    //itemReview.setUser( );
    //System.out.println(itemReview.getUser());
    return itemReviewRepository.save(itemReview);
  }
}
