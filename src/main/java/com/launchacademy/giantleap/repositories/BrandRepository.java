package com.launchacademy.giantleap.repositories;

import com.launchacademy.models.Brand;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer> {
  Brand findById(int id);
  Brand findByName(String name);
}