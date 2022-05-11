package mj.mjfood;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Dislike;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {
    
    private final InitService initService;
    
    @PostConstruct
    public void init() {
        initService.dbInit1();
    }
    

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            Dislike dislike1 = createDislike("갑각류");
            em.persist(dislike1);

            Dislike dislike2 = createDislike("달걀");
            em.persist(dislike2);

            Dislike dislike3 = createDislike("밀");
            em.persist(dislike3);

            Dislike dislike4 = createDislike("우유");
            em.persist(dislike4);

            Dislike dislike5 = createDislike("콩");
            em.persist(dislike5);

            Dislike dislike6 = createDislike("견과");
            em.persist(dislike6);

            Dislike dislike7 = createDislike("땅콩");
            em.persist(dislike7);

            Dislike dislike8 = createDislike("생선");
            em.persist(dislike8);

            Dislike dislike9 = createDislike("조개");
            em.persist(dislike9);
        }

        private Dislike createDislike(String name) {
            Dislike dislike = new Dislike();
            dislike.changeName(name);
            return dislike;
        }
    }
}
