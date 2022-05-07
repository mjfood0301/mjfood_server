package mj.mjfood.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class UserDislike {

    @Id @GeneratedValue
    private long userDislikeId;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "dislikeId")
    private Dislike dislike;
}
