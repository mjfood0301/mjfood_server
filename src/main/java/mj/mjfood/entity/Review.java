package mj.mjfood.entity;

import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class Review extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId")
    private Store store;

    @Column(columnDefinition = "TEXT")
    private String content;

    private int rate;

    public static Review create(User user, Store store, int rate, String content) {
        Review review = new Review();
        review.changeUser(user);
        review.changeStore(store);
        review.createReview(rate, content);
        return review;
    }

    private void createReview(int rate, String content) {
        this.rate = rate;
        this.content = content;
    }

    private void changeStore(Store store) {
        this.store = store;
        store.addReview(this);
    }

    private void changeUser(User user) {
        this.user = user;
    }
}
