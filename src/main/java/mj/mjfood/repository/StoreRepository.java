package mj.mjfood.repository;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Store;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class StoreRepository {

    private final EntityManager em;

    public void save(Store store) {
        em.persist(store);
    }

    public Store findOne(Long id) {
        return em.find(Store.class, id);
    }
}
