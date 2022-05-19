package mj.mjfood.repository;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Food;
import mj.mjfood.entity.Ranks;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class RankRepository {

    private final EntityManager em;

    public void save(Ranks ranks) {
        em.persist(ranks);
    }

    public List<Ranks> findByFood(Food food) {
        return em.createQuery("select r from Ranks r where r.food = :food", Ranks.class)
                .setParameter("food", food)
                .getResultList();
    }

    public List<Ranks> findByRank() {
        return em.createQuery("select r from Ranks r order by r.count", Ranks.class)
                .setMaxResults(10)
                .getResultList();
    }
}
