package com.launchacademy.giantleap.repositories;

import com.launchacademy.models.Style;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends PagingAndSortingRepository<Style, Integer> {
  Style findById(int id);
  Style findByName(String name);
}