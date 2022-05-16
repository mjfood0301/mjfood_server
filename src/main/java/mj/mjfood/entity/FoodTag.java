package mj.mjfood.entity;

import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class FoodTag extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "food_tag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodId")
    private Food food;

    @ManyToOne()
    @JoinColumn(name = "tagId")
    private Tag tag;

    //==연관관계 메서드==//
    public void addFood(Food food) {
        this.food = food;
    }

    private void addTag(Tag tag) {
        this.tag = tag;
    }

    //==생성 메서드==//
    public static FoodTag createFoodTag(Tag tag) {
        FoodTag foodTag = new FoodTag();
        foodTag.addTag(tag);

        return foodTag;
    }

}
