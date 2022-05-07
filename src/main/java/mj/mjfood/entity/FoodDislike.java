package mj.mjfood.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class FoodDislike {

    @Id @GeneratedValue
    @Column(name = "food_dislike_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodId")
    private Food food;

    @ManyToOne()
    @JoinColumn(name = "dislikeId")
    private Dislike dislike;
}
