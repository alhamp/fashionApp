package com.launchacademy.giantleap.dtos;

import com.launchacademy.giantleap.models.FashionItem;
import com.launchacademy.giantleap.models.FashionItemReview;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class ItemsAndReviewsDTO {
  private Page<FashionItemReview> fashionItemReviews;
  private ItemDTO itemDTO;
  private boolean loggedIn;
}