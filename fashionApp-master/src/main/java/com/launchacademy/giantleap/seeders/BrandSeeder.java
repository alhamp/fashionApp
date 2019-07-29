package com.launchacademy.giantleap.seeders;

import com.launchacademy.giantleap.models.Brand;
import com.launchacademy.giantleap.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BrandSeeder implements CommandLineRunner {
  private final BrandRepository brandRepository;

  @Autowired
  public BrandSeeder(BrandRepository brandRepository) {
    this.brandRepository = brandRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    final String[] brands = {""};
    for(String brandName : brands) {
      if(brandRepository.findByName(brandName) == null) {
        Brand brand = new Brand();
        brand.setName(brandName);
        brandRepository.save(brand);
      }
    }
  }
}