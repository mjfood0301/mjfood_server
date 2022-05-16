package mj.mjfood.entity;

import lombok.Getter;
import mj.mjfood.config.BaseException;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import static mj.mjfood.config.BaseResponseStatus.CHECK_QUIT_USER;
import static mj.mjfood.config.BaseResponseStatus.DELETE_LIKE_EXISTS;

@Where(clause = "status='ACTIVE'")
@Getter
@Entity
public class Likes extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId")
    private Store store;

    public void delete() throws BaseException {
        if (getStatus() == Status.DELETED) {
            throw new BaseException(DELETE_LIKE_EXISTS);
        }
        this.changeStatus(Status.DELETED);
    }

    //==샛성 메서드==//
    public static Likes createLikes(User user, Store store) {
        Likes likes = new Likes();
        likes.changeUser(user);
        likes.changeStore(store);
        return likes;
    }

    private void changeStore(Store store) {
        this.store = store;
    }

    private void changeUser(User user) {
        this.user = user;
    }
}
