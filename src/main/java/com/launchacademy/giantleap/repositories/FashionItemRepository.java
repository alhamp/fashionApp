package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.FashionItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FashionItemRepository extends PagingAndSortingRepository<FashionItem, Integer> {
<<<<<<< HEAD
  FashionItem findById(int id);
=======
  FashionItem findByName(String name);
>>>>>>> 9b282cc261d648f8c0090a24a0ab8d2468b25dbf
}
