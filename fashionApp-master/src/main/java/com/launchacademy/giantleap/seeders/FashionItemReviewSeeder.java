package com.launchacademy.giantleap.seeders;

import com.launchacademy.giantleap.models.FashionItemReview;
import com.launchacademy.giantleap.repositories.FashionItemReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FashionItemReviewSeeder implements CommandLineRunner {
  private final FashionItemReviewRepository fashionItemReviewRepository;

@Autowired
public FashionItemReviewSeeder(
    FashionItemReviewRepository fashionItemReviewRepository){ this.fashionItemReviewRepository = fashionItemReviewRepository;}

@Override
public void run(String... args) throws Exception {
  final String[] itemReviews = {""};
  for (String itemReviewName : itemReviews) {
    if (fashionItemReviewRepository.findById(0) == null) {
      FashionItemReview fashionItemReview = new FashionItemReview();
      fashionItemReviewRepository.save(fashionItemReview);
     }
   }
 }
}