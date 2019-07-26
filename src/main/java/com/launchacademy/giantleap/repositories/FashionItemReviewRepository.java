package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.FashionItemReview;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FashionItemReviewRepository extends PagingAndSortingRepository<FashionItemReview, Integer> {
}

