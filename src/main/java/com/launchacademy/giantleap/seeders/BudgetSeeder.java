package com.launchacademy.giantleap.seeders;

import com.launchacademy.giantleap.models.Budget;
import com.launchacademy.giantleap.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
  public class BudgetSeeder implements CommandLineRunner {
  private final BudgetRepository budgetRepository;

@Autowired
  public BudgetSeeder(BudgetRepository budgetRepository) { this.budgetRepository = budgetRepository;}

@Override
  public void run(String... args) throws Exception {
  final Integer[] budgets = {};
  for(Integer budgetOption : budgets){
    if (budgetRepository.findByPrice(budgetOption) == null) {
      Budget budget = new Budget();
      budget.setPrice(budgetOption);
      budgetRepository.save(budget);
      }
    }
  }
}
