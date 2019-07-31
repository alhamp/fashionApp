package com.launchacademy.giantleap.dtos;

import com.launchacademy.giantleap.models.FashionItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndexItemsDTO {
  private Integer id;
  private String name;
  private String photo;
  public IndexItemsDTO(FashionItem fashionItem) {
    this.id = fashionItem.getId();
    this.name = fashionItem.getName();
    this.photo = fashionItem.getPhoto();
  }
}
