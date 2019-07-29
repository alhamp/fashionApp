package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.Budget;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends PagingAndSortingRepository<Budget, Integer> {
}