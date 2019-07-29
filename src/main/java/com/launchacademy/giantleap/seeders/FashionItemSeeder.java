package com.launchacademy.giantleap.seeders;

import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.repositories.FashionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FashionItemSeeder implements CommandLineRunner {
  private final FashionItemRepository fashionItemRepository;

@Autowired
  public  FashionItemSeeder(FashionItemRepository fashionItemRepository){ this.fashionItemRepository = fashionItemRepository; }

  @Override
  public void run(String... args) throws Exception {
    final String[] fashionItems = {""};
    for(String fashionItemName : fashionItems) {
      if(fashionItemRepository.findByName(fashionItemName) == null) {
        FashionItem fashionItem = new FashionItem();
        fashionItem.setName(fashionItemName);
        fashionItemRepository.save(fashionItem);
      }
    }
  }
}
