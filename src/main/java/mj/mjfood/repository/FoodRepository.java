package mj.mjfood.repository;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Food;
import mj.mjfood.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class FoodRepository {

    private final EntityManager em;

    public void save(Food food) {
        em.persist(food);
    }

    public Food findOne(Long id) {
        return em.find(Food.class, id);
    }

    public List<Food> findByName(String name) {
        return em.createQuery("select f from Food f where f.name = :name", Food.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Food> findAllByString(String keyword) {
        return em.createQuery("select f from Food f where f.name like :keyword", Food.class)
                .setParameter("keyword", "%"+keyword+"%")
                .getResultList();
    }
}
