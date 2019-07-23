package com.launchacademy.giantleap.repositories;

import com.launchacademy.models.ClothingType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingTypeRepository extends PagingAndSortingRepository<ClothingType, Integer> {
  ClothingType findById(int id);
  ClothingType findByName(String name);
}