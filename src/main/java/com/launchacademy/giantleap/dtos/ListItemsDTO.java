package com.launchacademy.giantleap.dtos;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListItemsDTO {
  private List<IndexItemsDTO> indexItemsDTOS;
}
