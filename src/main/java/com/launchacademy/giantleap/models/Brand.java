package com.launchacademy.giantleap.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="brand")
@Getter
@Setter
@NoArgsConstructor

public class Brand {
  @Id
  @SequenceGenerator(name= "brand_generator", sequenceName = "brand_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NonNull
  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "brand")
  private List<FashionItem> fashionItems = new ArrayList<FashionItem>();
}
