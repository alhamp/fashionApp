package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.FashionItemReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD:src/main/java/com/launchacademy/giantleap/repositories/ItemReviewRepository.java
import java.util.Optional;

public interface ItemReviewRepository extends PagingAndSortingRepository<FashionItemReview, Integer> {
    Page<FashionItemReview> findAllByFashionItem(Optional <FashionItem> fashionItem, Pageable pageable);
=======
public interface FashionItemReviewRepository extends PagingAndSortingRepository<FashionItemReview, Integer> {
  Page<FashionItemReview> findAllByFashionItem(FashionItem fashionItem, Pageable pageable);
>>>>>>> c63072f23b281cb477d68c87b9140bca6bc3cef4:src/main/java/com/launchacademy/giantleap/repositories/FashionItemReviewRepository.java
}
