package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.Brand;
import com.launchacademy.giantleap.models.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer> {
  Role findByName(String name);
}