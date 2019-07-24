package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.FashionItemReview;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemReviewRepository extends PagingAndSortingRepository<FashionItemReview, Integer> {
}

