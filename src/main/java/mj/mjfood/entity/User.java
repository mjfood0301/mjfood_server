package mj.mjfood.entity;

import lombok.Getter;
import mj.mjfood.config.BaseException;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static mj.mjfood.config.BaseResponseStatus.CHECK_QUIT_USER;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class User extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column(length = 20)
    private String name;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
   private List<UserDislike> userDislikes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Likes> likes = new ArrayList<>();

    //연관관계 메서드
    public void addUserDislike(UserDislike... userDislikes) {
        for (UserDislike userDislike : userDislikes) {
            this.userDislikes.add(userDislike);
            userDislike.addUser(this);
        }
    }

    private void removeUserDislike(UserDislike userDislike) {
        userDislikes.remove(userDislike);
        userDislike.removeUserDislike();
    }

    //생성 메서드
    public void createUser(String email, String name, String image) {
        this.email = email;
        this.name = name;
        this.image = image;
    }

    //비즈니스 로직
    public void quit() throws BaseException {
        if (getStatus() == Status.DELETED) {
            throw new BaseException(CHECK_QUIT_USER);
        }
        this.changeStatus(Status.DELETED);

    }

    public void deleteDislikes(Dislike dislike) {
        for (UserDislike userDislike : userDislikes) {
            if (dislike.equals(userDislike.getDislike())) {
                removeUserDislike(userDislike);
                userDislike.removeUserDislike();
                return;
            }
        }
    }


}
