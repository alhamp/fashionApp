package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.FashionItemReview;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface FashionItemReviewRepository extends PagingAndSortingRepository<FashionItemReview, Integer> {
  Page<FashionItemReview> findAllByFashionItem(Optional<FashionItem> fashionItem, Pageable pageable);
}

