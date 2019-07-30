package com.launchacademy.giantleap.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.jackson.JsonComponent;

@Entity
@Table(name="fashion_items")
@Getter
@Setter
@NoArgsConstructor
public class FashionItem {
  @Id
  @SequenceGenerator(name= "fashion_items_generator", sequenceName = "fashion_items_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fashion_items_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @Column
  private String name;

  @Column
  private String photo;

  @Column
  private String measurements;

  @Column
  private Integer quality;

  @Column(name="fabric_weight")
  private Integer fabricWeight;

  @Column(name="body_type")
  private String bodyType;

  @Column(name="item_size")
  private Integer itemSize;
  
  @ManyToMany
  @JoinTable(
      name="items_styles",
      joinColumns={@JoinColumn(name="fashion_item_id")},
      inverseJoinColumns = {@JoinColumn(name="style_id")}
  )
  private List<Style> styles = new ArrayList<Style>();

  @ManyToOne
  @JoinColumn(name="clothing_type_id")
  private ClothingType clothingType;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="budget_id")
  private Budget budget;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="brand_id")
  private Brand brand;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;
}
