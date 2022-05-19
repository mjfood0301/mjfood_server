package mj.mjfood.entity;

import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class Ranks extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "rank_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "foodId")
    private Food food;

    private int count;

    public static Ranks create(Food food) {
        Ranks ranks = new Ranks();
        ranks.createRank(food);

        return ranks;
    }

    private void createRank(Food food) {
        this.food = food;
        count = 1;
    }

    public void minusCount() {
        if (count > 0) {
            count--;
        }
    }

    public void plusCount() {
        count++;
    }
}
