package mj.mjfood.entity;

import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class FoodDislike extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "food_dislike_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodId")
    private Food food;

    @ManyToOne()
    @JoinColumn(name = "dislikeId")
    private Dislike dislike;

    //==연관관계 메서드==//
    public void addFood(Food food) {
        this.food = food;
    }

    public void addDislike(Dislike dislike) {
        this.dislike = dislike;
    }

    //==생성 메서드==//
    public static FoodDislike createFoodDislike(Dislike dislike) {
        FoodDislike foodDislike = new FoodDislike();
        foodDislike.addDislike(dislike);

        return foodDislike;
    }
}
