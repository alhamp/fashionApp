package com.launchacademy.giantleap.seeders;

import com.launchacademy.giantleap.models.FashionItemReview;
import com.launchacademy.giantleap.repositories.ItemReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemReviewSeeder implements CommandLineRunner {
  private final ItemReviewRepository itemReviewRepository;

@Autowired
public ItemReviewSeeder(ItemReviewRepository itemReviewRepository){ this.itemReviewRepository = itemReviewRepository;}

@Override
public void run(String... args) throws Exception {
  final String[] itemReviews = {""};
  for (String itemReviewName : itemReviews) {
    if (itemReviewRepository.findByName(itemReviewName) == null) {
      FashionItemReview fashionItemReview = new FashionItemReview();
      FashionItemReview.setName(itemReviewName);
      itemReviewRepository.save(fashionItemReview);
     }
   }
 }
}
