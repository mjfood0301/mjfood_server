package mj.mjfood.repository;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Dislike;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class DislikeRepository {

    private final EntityManager em;

    public void save(Dislike dislike) {
        em.persist(dislike);
    }

    public Dislike findOne(Long id) {
        return em.find(Dislike.class, id);
    }


}
