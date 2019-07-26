package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.FashionItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FashionItemRepository extends PagingAndSortingRepository<FashionItem, Integer> {
  FashionItem findById(int id);
}
