package com.launchacademy.giantleap.controllers;

import com.launchacademy.giantleap.models.Budget;
import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.FashionItemNotFoundException;
import com.launchacademy.giantleap.models.Style;
import com.launchacademy.giantleap.repositories.FashionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FashionItemRestController {

  public final FashionItemRepository fashionItemRepository;

  @Autowired
  public FashionItemRestController(FashionItemRepository fashionItemRepository){
    this.fashionItemRepository = fashionItemRepository;
  }

  @GetMapping("api/v1/fashion")
  public Page<FashionItem> getFashionItems(Pageable pageable){
    return fashionItemRepository.findAll(pageable);
  }

  @GetMapping("/api/v1/fashion/{id}")
  public FashionItem getOneItem(@PathVariable Integer id) {
    return fashionItemRepository.findById(id).orElseThrow(() -> new FashionItemNotFoundException());
  }

  @GetMapping("api/v1/fashion")
  public Page<FashionItem> getFashionItemsByParams(@PathVariable("budget") Budget budget,
      @PathVariable("style") Style style, Pageable pageable){
    return fashionItemRepository.findByBudgetAndStyle(budget, style, pageable);
  }

  @PostMapping("api/v1/fashion")
  public FashionItem newFashionItem(@RequestBody FashionItem fashionItem, Model model){
    return fashionItemRepository.save(fashionItem);
  }
}
