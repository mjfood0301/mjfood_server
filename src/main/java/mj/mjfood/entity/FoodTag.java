package mj.mjfood.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class FoodTag {

    @Id @GeneratedValue
    @Column(name = "food_tag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodId")
    private Food food;

    @ManyToOne()
    @JoinColumn(name = "tagId")
    private Tag tag;
}
