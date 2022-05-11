package mj.mjfood.repository;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Dislike;
import mj.mjfood.entity.User;
import mj.mjfood.entity.UserDislike;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserDislikeRepository {

    private final EntityManager em;

    public void save(UserDislike userDislike) {
        em.persist(userDislike);
    }

    public List<UserDislike> findByUserDislike(User user, Dislike dislike) {
        return em.createQuery("select ud from UserDislike ud where ud.user = :user and ud.dislike = :dislike", UserDislike.class)
                .setParameter("user", user)
                .setParameter("dislike", dislike)
                .getResultList();
    }
}
