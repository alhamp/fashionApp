package com.launchacademy.giantleap.repositories;

import com.launchacademy.models.Budget;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends PagingAndSortingRepository<Budget, Integer> {
  Budget findById(int id);
  Budget findByName(Integer price);
}