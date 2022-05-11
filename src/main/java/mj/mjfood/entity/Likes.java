package mj.mjfood.entity;

import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class Likes extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "like_id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId")
    private Store store;
}
