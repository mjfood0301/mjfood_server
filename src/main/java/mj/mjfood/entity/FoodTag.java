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
}
