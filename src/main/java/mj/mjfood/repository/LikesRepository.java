package mj.mjfood.repository;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Likes;
import mj.mjfood.entity.Store;
import mj.mjfood.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class LikesRepository {

    private final EntityManager em;

    public void save(Likes likes) {
        em.persist(likes);
    }

    public List<Likes> findByUser(User user) {
        return em.createQuery("select l from Likes l where l.user = :user", Likes.class)
                .setParameter("user", user)
                .getResultList();
    }

    public List<Likes> findByUserAndStore(User user, Store store) {
        return em.createQuery("select l from Likes l where l.user = :user and l.store = :store", Likes.class)
                .setParameter("user", user)
                .setParameter("store", store)
                .getResultList();
    }
}
