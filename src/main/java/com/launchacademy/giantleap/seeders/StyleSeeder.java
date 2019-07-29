package com.launchacademy.giantleap.seeders;

import com.launchacademy.giantleap.models.Style;
import com.launchacademy.giantleap.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StyleSeeder implements CommandLineRunner {
  private final StyleRepository styleRepository;

@Autowired
  public StyleSeeder(StyleRepository styleRepository) { this.styleRepository = styleRepository; }

@Override
  public void run(String... args) throws Exception {
  final String[] styles = {""};
  for(String styleName : styles) {
    if(styleRepository.findByName(styleName) == null) {
      Style style = new Style();
      style.setName(styleName);
      styleRepository.save(style);
     }
   }
 }
}
