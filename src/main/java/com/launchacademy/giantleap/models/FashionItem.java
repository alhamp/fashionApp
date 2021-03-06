package com.launchacademy.giantleap.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="fashion_items")
@Getter
@Setter
@NoArgsConstructor
@ToString
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

  @ManyToOne
  @JoinColumn(name="style_id")
  private Style style;

  @ManyToOne
  @JoinColumn(name="clothing_type_id")
  private ClothingType clothingType;

  @ManyToOne
  @JoinColumn(name="budget_id")
  private Budget budget;

  @ManyToOne
  @JoinColumn(name="brand_id")
  private Brand brand;

  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;
}