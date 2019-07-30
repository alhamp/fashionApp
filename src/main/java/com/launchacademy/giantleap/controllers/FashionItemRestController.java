package com.launchacademy.giantleap.controllers;

import com.launchacademy.giantleap.models.ClothingType;
import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.FashionItemNotFoundException;
import com.launchacademy.giantleap.repositories.ClothingTypeRepository;
import com.launchacademy.giantleap.repositories.FashionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FashionItemRestController {

  public final FashionItemRepository fashionItemRepository;
  public final ClothingTypeRepository clothingTypeRepository;

  @Autowired
  public FashionItemRestController(FashionItemRepository fashionItemRepository, ClothingTypeRepository clothingTypeRepository){
    this.fashionItemRepository = fashionItemRepository;
    this.clothingTypeRepository = clothingTypeRepository;
  }

  @GetMapping("api/v1/fashion")
  public Page<FashionItem> getFashionItems(Pageable pageable){
    return fashionItemRepository.findAll(pageable);
  }

  @GetMapping("/api/v1/fashion/{id}")
  public FashionItem getOneItem(@PathVariable Integer id) {
    return fashionItemRepository.findById(id).orElseThrow(() -> new FashionItemNotFoundException());
  }

  @PostMapping("/api/v1/fashion")
  public FashionItem newFashionItem(@RequestBody FashionItem fashionItem, Model model){
//    int clothing = fashionItem.getClothingType().getName();
//    Optional<ClothingType> clothingItem = clothingTypeRepository.findById(clothing);
//    fashionItem.setClothingType(clothingItem);
    System.out.println(fashionItem);
    return fashionItemRepository.save(fashionItem);
  }
}
