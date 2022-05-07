package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Review {

    @Id @GeneratedValue
    private Long reviewId;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId")
    private Store store;

    @Column(columnDefinition = "TEXT")
    private String content;

    private int rate;
}
