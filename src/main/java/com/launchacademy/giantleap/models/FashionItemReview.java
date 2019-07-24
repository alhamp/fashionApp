package com.launchacademy.giantleap.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

@Entity
@Table(name="fashion_item_reviews")
@Getter
@Setter
@NoArgsConstructor
public class FashionItemReview {
    @Id
    @SequenceGenerator(name= "fashion_item_reviews_generator", sequenceName = "fashion_item_reviews_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fashion_item_reviews_generator")
    @Column(name="id", nullable=false, unique=true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="fashion_item_id")
    private FashionItem fashionItem;

    @Column(name="body_type")
    private String bodyType;

    @Column(name="item_size")
    private Integer itemSize;

    @Column(name="quality")
    private Integer quality;

    @Column(name="comment")
    private String comment;

    @URL
    @Column
    private String photo;

    @Column
    private Integer rating;
}
