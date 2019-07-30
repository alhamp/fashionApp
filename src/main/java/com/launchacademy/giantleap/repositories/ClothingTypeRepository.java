package com.launchacademy.giantleap.repositories;

import com.launchacademy.giantleap.models.ClothingType;
import com.launchacademy.giantleap.models.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingTypeRepository extends PagingAndSortingRepository<ClothingType, Integer> {
  ClothingType findByName(String name);
<<<<<<< HEAD

=======
>>>>>>> c63072f23b281cb477d68c87b9140bca6bc3cef4
}