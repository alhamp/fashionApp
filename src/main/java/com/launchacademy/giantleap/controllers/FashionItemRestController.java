package com.launchacademy.giantleap.controllers;

<<<<<<< HEAD
import com.launchacademy.giantleap.models.ClothingType;
import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.FashionItemNotFoundException;
import com.launchacademy.giantleap.repositories.ClothingTypeRepository;
=======
import com.launchacademy.giantleap.dtos.ItemsAndReviewsDTO;
import com.launchacademy.giantleap.models.Budget;
import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.FashionItemNotFoundException;
import com.launchacademy.giantleap.models.FashionItemReview;
import com.launchacademy.giantleap.models.Style;
>>>>>>> c63072f23b281cb477d68c87b9140bca6bc3cef4
import com.launchacademy.giantleap.repositories.FashionItemRepository;
import com.launchacademy.giantleap.repositories.FashionItemReviewRepository;
import com.launchacademy.giantleap.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FashionItemRestController {

<<<<<<< HEAD
  public final FashionItemRepository fashionItemRepository;
  public final ClothingTypeRepository clothingTypeRepository;

  @Autowired
  public FashionItemRestController(FashionItemRepository fashionItemRepository, ClothingTypeRepository clothingTypeRepository){
    this.fashionItemRepository = fashionItemRepository;
    this.clothingTypeRepository = clothingTypeRepository;
=======
  private final FashionItemRepository fashionItemRepository;
  private final FashionItemReviewRepository fashionItemReviewRepository;
  private final UserRepository userRepository;

  @Autowired
  public FashionItemRestController(FashionItemRepository fashionItemRepository,
      FashionItemReviewRepository fashionItemReviewRepository,
      UserRepository userRepository){
    this.fashionItemRepository = fashionItemRepository;
    this.fashionItemReviewRepository = fashionItemReviewRepository;
    this.userRepository = userRepository;
>>>>>>> c63072f23b281cb477d68c87b9140bca6bc3cef4
  }

  @GetMapping("api/v1/fashion")
  public Page<FashionItem> getFashionItems(Pageable pageable){
    return fashionItemRepository.findAll(pageable);
  }

  @GetMapping("/api/v1/fashion/{id}")
  public ResponseEntity getOneItem(@PathVariable Integer id, @Autowired ItemsAndReviewsDTO itemsAndReviewsDTO, Pageable pageable) {
    FashionItem fashionItem = fashionItemRepository.findById(id).orElseThrow(() -> new FashionItemNotFoundException());
    Page<FashionItemReview> fashionItemReviews = fashionItemReviewRepository.findAllByFashionItem(fashionItem, pageable);
    itemsAndReviewsDTO.setFashionItem(fashionItem);
    itemsAndReviewsDTO.setFashionItemReviews(fashionItemReviews);
    return new ResponseEntity<ItemsAndReviewsDTO>(itemsAndReviewsDTO, HttpStatus.OK);
  }

  @GetMapping("api/v1/fashion-query")
  public Page<FashionItem> getFashionItemsByParams(@PathVariable("budget") Budget budget,
      @PathVariable("style") Style style, Pageable pageable){
    return fashionItemRepository.findByBudgetAndStyle(budget, style, pageable);
  }

  @PostMapping("/api/v1/fashion")
  public FashionItem newFashionItem(@RequestBody FashionItem fashionItem, Model model){
//    int clothing = fashionItem.getClothingType().getName();
//    Optional<ClothingType> clothingItem = clothingTypeRepository.findById(clothing);
//    fashionItem.setClothingType(clothingItem);
    System.out.println(fashionItem);
    return fashionItemRepository.save(fashionItem);
  }

  @PostMapping("api/v1/reviews/{id}")
  public FashionItemReview addReview(@RequestBody FashionItemReview itemReview, @PathVariable Integer id,
      Authentication authentication){
    org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)authentication.getPrincipal();
    String username = user.getUsername();
    com.launchacademy.giantleap.models.User currentUser = userRepository.findByUsername(username);
    itemReview.setUser(currentUser);
    FashionItem fashionItem = fashionItemRepository.findById(id).orElseThrow(() -> new FashionItemNotFoundException());
    itemReview.setFashionItem(fashionItem);
    System.out.println(itemReview.toString());
    return fashionItemReviewRepository.save(itemReview);
  }
}
