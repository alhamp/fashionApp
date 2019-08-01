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
  FashionItem findById(int id);
  FashionItem findByName(String name);
  @Query(value = "SELECT f FROM FashionItem f WHERE f.budget.id <= :budget AND f.style.id = :style")
  public Page<FashionItem> findByBudgetAndStyle(@Param("budget") Integer budget, @Param("style") Integer style, Pageable pageable);

  @Query(value = "SELECT f FROM FashionItem f WHERE f.budget.id < :budget")
  Page<FashionItem> findByBudget(@Param("budget") Integer budget, Pageable pageable);

  @Query(value = "SELECT f FROM FashionItem f WHERE f.style.id = :style")
  Page<FashionItem> findByStyle(@Param("style") Integer style, Pageable pageable);
}