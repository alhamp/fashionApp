package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.Budget;
import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.Style;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface FashionItemRepository extends PagingAndSortingRepository<FashionItem, Integer> {
<<<<<<< HEAD
  FashionItem findByName(String name);
=======
  FashionItem findById(int id);
  FashionItem findByName(String name);

  @Query(value = "SELECT f FROM FashionItem f WHERE f.budget = :budget AND f.style = :style", nativeQuery = true)
  public Page<FashionItem> findByBudgetAndStyle(@Param("budget") Budget budget, @Param("style") Style style, Pageable pageable);
>>>>>>> c63072f23b281cb477d68c87b9140bca6bc3cef4
}
