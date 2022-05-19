package mj.mjfood.repository;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Food;
import mj.mjfood.entity.FoodTag;
import mj.mjfood.entity.Tag;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

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

    public List<FoodTag> findByTag(Tag tag) {
        return em.createQuery("select ft from FoodTag ft where ft.tag = :tag", FoodTag.class)
                .setParameter("tag", tag)
                .getResultList();
    }
}
