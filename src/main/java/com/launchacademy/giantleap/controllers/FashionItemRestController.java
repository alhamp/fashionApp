package com.launchacademy.giantleap.controllers;

import com.launchacademy.giantleap.dtos.IndexItemsDTO;
import com.launchacademy.giantleap.dtos.ItemDTO;
import com.launchacademy.giantleap.dtos.ItemsAndReviewsDTO;
import com.launchacademy.giantleap.dtos.ListItemsDTO;
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
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
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
  public ResponseEntity getFashionItems(Pageable pageable){
    Page<FashionItem> fashionItems = fashionItemRepository.findAll(pageable);
    List<IndexItemsDTO> indexItemsDTOs = new ArrayList<>();
    for(FashionItem item : fashionItems){
      IndexItemsDTO indexItemsDTO = new IndexItemsDTO(item);
      indexItemsDTOs.add(indexItemsDTO);
    }
    ListItemsDTO listItemsDTO = new ListItemsDTO();
    listItemsDTO.setIndexItemsDTOS(indexItemsDTOs);
    return new ResponseEntity<ListItemsDTO>(listItemsDTO, HttpStatus.OK);
  }

  @GetMapping("/api/v1/fashion/{id}")
  public ResponseEntity getOneItem(@PathVariable Integer id, @Autowired ItemsAndReviewsDTO itemsAndReviewsDTO, Pageable pageable) {
    FashionItem fashionItem = fashionItemRepository.findById(id).orElseThrow(() -> new FashionItemNotFoundException());
    Page<FashionItemReview> fashionItemReviews = fashionItemReviewRepository.findAllByFashionItem(fashionItem, pageable);
    ItemDTO itemDTO = new ItemDTO();
    //how to check if not logged in?
    if(fashionItem.getStyle() != null) {
      itemDTO.setStyle(fashionItem.getStyle().getName());
    }
    itemDTO.setId(fashionItem.getId());
    if(fashionItem.getBrand() != null) {
      itemDTO.setBrand(fashionItem.getBrand().getName());
    }
    if(fashionItem.getBudget() != null) {
      itemDTO.setBudget(fashionItem.getBudget().getPrice());
    }
    if(fashionItem.getClothingType() != null) {
      itemDTO.setClothingType(fashionItem.getClothingType().getName());
    }
    if(fashionItem.getItemSize() != null){
      itemDTO.setItemSize(fashionItem.getItemSize());
    }
    if(fashionItem.getMeasurements() != null) {
      itemDTO.setMeasurements(fashionItem.getMeasurements());
    }
    if(fashionItem.getName() != null) {
      itemDTO.setName(fashionItem.getName());
    }
    if(fashionItem.getPhoto() != null){
      itemDTO.setPhoto(fashionItem.getPhoto());
    }
    if(fashionItem.getQuality() != null){
      itemDTO.setQuality(fashionItem.getQuality());
    }
    itemsAndReviewsDTO.setItemDTO(itemDTO);
    itemsAndReviewsDTO.setFashionItemReviews(fashionItemReviews);
    return new ResponseEntity<ItemsAndReviewsDTO>(itemsAndReviewsDTO, HttpStatus.OK);
  }

  @GetMapping("api/v1/budget/")
  public Page<FashionItem> getFashionItemsByBudget(@RequestParam("budget") Integer budget, Pageable pageable){
    Budget budgetEntity = budgetRepository.findByPrice(budget);
    int budgetId = budgetEntity.getId();
    return fashionItemRepository.findByBudget(budgetId, pageable);
  }
  @GetMapping("api/v1/style/")
  public Page<FashionItem> getFashionItemsByStyle(@RequestParam("style") String style, Pageable pageable){
    Style styleEntity = styleRepository.findByName(style);
    int styleid = styleEntity.getId();
    return fashionItemRepository.findByStyle(styleid, pageable);
  }
  @GetMapping("api/v1/fashion/")
  public Page<FashionItem> getFashionItemsByParams(@RequestParam("budget") Integer budget,
      @RequestParam("style") String style, Pageable pageable){
    Budget budgetEntity = budgetRepository.findByPrice(budget);
    int budgetId = budgetEntity.getId();
    Style styleEntity = styleRepository.findByName(style);
    int styleId = styleEntity.getId();
    Page<FashionItem> page = fashionItemRepository.findByBudgetAndStyle(budgetId, styleId, pageable);
    return page;
  }

  @PostMapping("/api/v1/fashion")
  public FashionItem newFashionItem(@RequestBody ItemDTO itemDTO, @Autowired FashionItem fashionItem, Model model, Authentication authentication){
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
      Budget budget;
      if(budgetRepository.findByPrice(itemDTO.getBudget()) != null){
        budget = budgetRepository.findByPrice(itemDTO.getBudget());
        fashionItem.setBudget(budget);
      } else {
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
    return fashionItemReviewRepository.save(itemReview);
  }
}
