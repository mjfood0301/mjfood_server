package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class FoodDislike {

    @Id @GeneratedValue
    private Long foodDislikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodId")
    private Food food;

    @ManyToOne()
    @JoinColumn(name = "dislikeId")
    private Dislike dislike;
}
