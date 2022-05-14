package mj.mjfood.repository;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.FoodTag;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Service
public class FoodTagRepository {

    private final EntityManager em;

    public void save(FoodTag foodTag) {
        em.persist(foodTag);
    }

    public FoodTag findOne(Long id) {
        return em.find(FoodTag.class, id);
    }
}
