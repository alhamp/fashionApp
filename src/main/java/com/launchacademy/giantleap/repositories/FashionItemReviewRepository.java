package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.FashionItemReview;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemReviewRepository extends PagingAndSortingRepository<FashionItemReview, Integer> {
  FashionItemReview findByName(String name);
}

