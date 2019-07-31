package com.launchacademy.giantleap.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ItemDTO {
  private boolean loggedIn;
  private Integer id;
  private String name;
  private String photo;
  private String measurements;
  private Integer quality;
  private Integer fabricWeight;
  private String bodyType;
  private Integer itemSize;
  private String style;
  private String clothingType;
  private Integer budget;
  private String brand;
}
