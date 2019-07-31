package com.launchacademy.giantleap.dtos;

import com.launchacademy.giantleap.models.FashionItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndexItemsDTO {
  private String name;
  private String photo;
  public IndexItemsDTO(FashionItem fashionItem) {
    this.name = fashionItem.getName();
    this.photo = fashionItem.getPhoto();
  }
}
