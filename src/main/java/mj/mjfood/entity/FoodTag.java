package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class FoodTag {

    @Id @GeneratedValue
    private Long foodTagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodId")
    private Food food;

    @ManyToOne()
    @JoinColumn(name = "tagId")
    private Tag tag;
}
