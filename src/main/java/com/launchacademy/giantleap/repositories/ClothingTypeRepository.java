package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.ClothingType;
import com.launchacademy.giantleap.models.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingTypeRepository extends PagingAndSortingRepository<ClothingType, Integer> {
  Role findByName(String name);
}