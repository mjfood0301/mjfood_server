package mj.mjfood.repository;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.FoodDislike;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Service
public class FoodDislikeRepository {

    private final EntityManager em;

    public void save(FoodDislike foodDislike) {
        em.persist(foodDislike);
    }

    public FoodDislike findOne(Long id) {
        return em.find(FoodDislike.class, id);
    }
}
