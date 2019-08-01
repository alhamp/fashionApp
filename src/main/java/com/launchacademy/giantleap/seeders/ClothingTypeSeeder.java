package com.launchacademy.giantleap.seeders;

import com.launchacademy.giantleap.models.ClothingType;
import com.launchacademy.giantleap.repositories.ClothingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClothingTypeSeeder implements CommandLineRunner {
  private final ClothingTypeRepository clothingTypeRepository;

@Autowired
  public ClothingTypeSeeder(ClothingTypeRepository clothingTypeRepository) { this.clothingTypeRepository = clothingTypeRepository; }

@Override
  public void run(String... args) throws Exception {
    final String[] clothingTypes = {"Tops","jackets", "blazers", "coats","dresses","jumpsuits","knitwear","shirts|blouses","t-shirts","pants","jeans","shorts","skirts","swimwear"};
    for (String clothingTypeName: clothingTypes){
      if(clothingTypeRepository.findByName(clothingTypeName) == null) {
        ClothingType clothingType = new ClothingType();
        clothingType.setName(clothingTypeName);
        clothingTypeRepository.save(clothingType);
      }
    }
  }
}