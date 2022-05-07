package mj.mjfood.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class UserDislike {

    @Id @GeneratedValue
    @Column(name = "user_dislike_id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "dislikeId")
    private Dislike dislike;
}
