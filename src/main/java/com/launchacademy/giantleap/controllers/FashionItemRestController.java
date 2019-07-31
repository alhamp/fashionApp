package com.launchacademy.giantleap.controllers;

import com.launchacademy.giantleap.dtos.ItemDTO;
import com.launchacademy.giantleap.dtos.ItemsAndReviewsDTO;
import com.launchacademy.giantleap.models.Brand;
import com.launchacademy.giantleap.models.Budget;
import com.launchacademy.giantleap.models.ClothingType;
import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.FashionItemNotFoundException;
import com.launchacademy.giantleap.models.FashionItemReview;
import com.launchacademy.giantleap.models.Style;
import com.launchacademy.giantleap.repositories.BrandRepository;
import com.launchacademy.giantleap.repositories.BudgetRepository;
import com.launchacademy.giantleap.repositories.ClothingTypeRepository;
import com.launchacademy.giantleap.repositories.FashionItemRepository;
import com.launchacademy.giantleap.repositories.FashionItemReviewRepository;
import com.launchacademy.giantleap.repositories.StyleRepository;
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

  private final FashionItemRepository fashionItemRepository;
  private final FashionItemReviewRepository fashionItemReviewRepository;
  private final UserRepository userRepository;

  @Autowired
  private BrandRepository brandRepository;
  @Autowired
  private BudgetRepository budgetRepository;
  @Autowired
  private ClothingTypeRepository clothingTypeRepository;
  @Autowired
  private StyleRepository styleRepository;

  @Autowired
  public FashionItemRestController(FashionItemRepository fashionItemRepository,
      FashionItemReviewRepository fashionItemReviewRepository,
      UserRepository userRepository){
    this.fashionItemRepository = fashionItemRepository;
    this.fashionItemReviewRepository = fashionItemReviewRepository;
    this.userRepository = userRepository;
  }

  @GetMapping("api/v1/fashion")
  public Page<FashionItem> getFashionItems(Pageable pageable){
    return fashionItemRepository.findAll(pageable);
  }

  @GetMapping("/api/v1/fashion/{id}")
  public ResponseEntity getOneItem(@PathVariable Integer id, @Autowired ItemsAndReviewsDTO itemsAndReviewsDTO, Pageable pageable) {
    FashionItem fashionItem = fashionItemRepository.findById(id).orElseThrow(() -> new FashionItemNotFoundException());
    Page<FashionItemReview> fashionItemReviews = fashionItemReviewRepository.findAllByFashionItem(fashionItem, pageable);
    ItemDTO itemDTO = new ItemDTO();
    //how to check if not logged in?
    System.out.println(fashionItem.toString());
    //itemDTO.setStyle(fashionItem.getStyle().getName());
    itemDTO.setId(fashionItem.getId());
    itemDTO.setBrand(fashionItem.getBrand().getName());
    System.out.println(fashionItem.getBudget().getPrice());
    itemDTO.setBudget(fashionItem.getBudget().getPrice());
    //itemDTO.setClothingType(fashionItem.getClothingType().getName());
    itemDTO.setItemSize(fashionItem.getItemSize());
    itemDTO.setMeasurements(fashionItem.getMeasurements());
    itemDTO.setName(fashionItem.getName());
    itemDTO.setPhoto(fashionItem.getPhoto());
    itemDTO.setQuality(fashionItem.getQuality());
    System.out.println(itemDTO);
    itemsAndReviewsDTO.setItemDTO(itemDTO);
    itemsAndReviewsDTO.setFashionItemReviews(fashionItemReviews);
    return new ResponseEntity<ItemsAndReviewsDTO>(itemsAndReviewsDTO, HttpStatus.OK);
  }

  @GetMapping("api/v1/fashion-query")
  public Page<FashionItem> getFashionItemsByParams(@PathVariable("budget") Budget budget,
      @PathVariable("style") Style style, Pageable pageable){
    return fashionItemRepository.findByBudgetAndStyle(budget, style, pageable);
  }

  @PostMapping("/api/v1/fashion")
  public FashionItem newFashionItem(@RequestBody ItemDTO itemDTO, @Autowired FashionItem fashionItem, Model model, Authentication authentication){
    System.out.println(itemDTO);
    String brandString = itemDTO.getBrand();
    Brand brand;
    if(brandRepository.findByName((brandString)) != null){
       brand = brandRepository.findByName(brandString);
    }
    else{
      brand = new Brand();
      brand.setName(brandString);
      brandRepository.save(brand);
    }
    fashionItem.setBrand(brand);
    fashionItem.setName(itemDTO.getName());
    fashionItem.setBodyType(itemDTO.getBodyType());

    if(itemDTO.getBudget() != null) {
      System.out.println(itemDTO.getBudget());
      Budget budget;
      try {
        budget = budgetRepository.findByPrice(itemDTO.getBudget());
        fashionItem.setBudget(budget);
      } catch (NullPointerException exception) {
        budget = new Budget();
        budget.setPrice(itemDTO.getBudget());
        budgetRepository.save(budget);
        fashionItem.setBudget(budget);
      }
    }

    if(itemDTO.getClothingType() != null){
      ClothingType clothingType;
      if(clothingTypeRepository.findByName(itemDTO.getClothingType()) != null){
        clothingType = clothingTypeRepository.findByName(itemDTO.getClothingType());
      }
      else{
        clothingType = new ClothingType();
        clothingType.setName(itemDTO.getClothingType());
        clothingTypeRepository.save(clothingType);
      }
      fashionItem.setClothingType(clothingType);
    }

    fashionItem.setItemSize(itemDTO.getItemSize());
    fashionItem.setMeasurements(itemDTO.getMeasurements());
    fashionItem.setPhoto(itemDTO.getPhoto());
    fashionItem.setQuality(itemDTO.getQuality());
    Style style;
    if(styleRepository.findByName(itemDTO.getStyle()) != null){
      style = styleRepository.findByName(itemDTO.getStyle());
    }
    else{
      style = new Style();
      style.setName(itemDTO.getStyle());
      styleRepository.save(style);
    }
    fashionItem.setStyle(style);
    org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)authentication.getPrincipal();
    String username = user.getUsername();
    com.launchacademy.giantleap.models.User currentUser = userRepository.findByUsername(username);
    fashionItem.setUser(currentUser);
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
