package com.launchacademy.giantleap.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="style")
@Getter
@Setter
@NoArgsConstructor

public class Style {
  @Id
  @SequenceGenerator(name= "style_generator",
      sequenceName = "styles_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "style_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;
  @NonNull
  @Column(nullable = false)
  private String name;
}

