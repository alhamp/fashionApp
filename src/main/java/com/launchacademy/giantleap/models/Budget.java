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
@Table(name="budget")
@Getter
@Setter
@NoArgsConstructor

public class Budget {

  @Id
  @SequenceGenerator(name = "budget_generator",
      sequenceName = "budgets_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "budget_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;
  @NonNull
  @Column(nullable = false)
  private Integer price;
}

