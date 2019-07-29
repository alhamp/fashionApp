package com.launchacademy.giantleap.controllers;

import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.FashionItemNotFoundException;
import com.launchacademy.giantleap.models.FashionItemReview;
import com.launchacademy.giantleap.models.User;
import com.launchacademy.giantleap.repositories.FashionItemRepository;
import com.launchacademy.giantleap.repositories.ItemReviewRepository;
import com.launchacademy.giantleap.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemReviewRestController {
  private final ItemReviewRepository itemReviewRepository;
  private final FashionItemRepository fashionItemRepository;
  private final UserRepository userRepository;

  @Autowired
  public ItemReviewRestController(ItemReviewRepository itemReviewRepository,
      FashionItemRepository fashionItemRepository,
      UserRepository userRepository){
    this.itemReviewRepository = itemReviewRepository;
    this.fashionItemRepository = fashionItemRepository;
    this.userRepository = userRepository;
  }

  @GetMapping("api/v1/reviews/{id}")
  public Page<FashionItemReview> getFashionItems(@PathVariable Integer id, Pageable pageable){
    Optional<FashionItem> fashionItem = fashionItemRepository.findById(id);
    return itemReviewRepository.findAllByFashionItem(fashionItem, pageable);
  }

  @PostMapping("api/v1/reviews/{id}")
  public FashionItemReview addReview(@RequestBody FashionItemReview itemReview, @PathVariable Integer id,
      Authentication authentication){
    org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)authentication.getPrincipal();
    String username = user.getUsername();
    User currentUser = userRepository.findByUsername(username);
    itemReview.setUser(currentUser);
    FashionItem fashionItem = fashionItemRepository.findById(id).orElseThrow(() -> new FashionItemNotFoundException());
    itemReview.setFashionItem(fashionItem);
    System.out.println(itemReview.toString());
    return itemReviewRepository.save(itemReview);
  }
}
