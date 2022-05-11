package mj.mjfood.entity;

import lombok.Getter;
import org.hibernate.annotations.Where;
import org.springframework.security.config.web.servlet.oauth2.login.UserInfoEndpointDsl;

import javax.persistence.*;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class UserDislike extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "user_dislike_id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "dislikeId")
    private Dislike dislike;

    public void addUser(User user) {
        this.user = user;
    }

    public void changeDislike(Dislike dislike) {
        this.dislike = dislike;
    }

    //생성메서드
    public static UserDislike createUserDislike(Dislike dislike) {
        UserDislike userDislike = new UserDislike();
        userDislike.changeDislike(dislike);

        return userDislike;
    }

    public void quit() {
    }

    public void removeUserDislike() {
        changeStatus(Status.DELETED);
    }
}
