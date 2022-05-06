package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Like {

    @Id @GeneratedValue
    private Long likeId;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId")
    private Store store;
}
