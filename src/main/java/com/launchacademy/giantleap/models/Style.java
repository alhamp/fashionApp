package com.launchacademy.giantleap.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

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
  @SequenceGenerator(name= "style_generator", sequenceName = "style_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "style_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NonNull
  @Column(nullable = false)
  private String name;
}

