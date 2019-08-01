package com.launchacademy.giantleap.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade=CascadeType.ALL)
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

    @Column
    private String photo;

    @Column
    private Integer rating;

    @Override
    public String toString() {
    return "FashionItemReview{" +
    "id=" + id +
    ", user=" + user +
    ", fashionItem=" + fashionItem +
    ", bodyType='" + bodyType + '\'' +
    ", itemSize=" + itemSize +
    ", quality=" + quality +
    ", comment='" + comment + '\'' +
    ", photo='" + photo + '\'' +
    ", rating=" + rating +
    '}';
    }
}