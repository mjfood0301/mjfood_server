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
            // Dislike 데이터 추가
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

            Dislike dislike10 = createDislike("오이");
            em.persist(dislike10);
            Dislike dislike11 = createDislike("콩");
            em.persist(dislike11);
            Dislike dislike12 = createDislike("시금치");
            em.persist(dislike12);
            Dislike dislike13 = createDislike("김치");
            em.persist(dislike13);
            Dislike dislike14 = createDislike("피망");
            em.persist(dislike14);
            Dislike dislike15 = createDislike("파프리카");
            em.persist(dislike15);
            Dislike dislike16 = createDislike("당근");
            em.persist(dislike16);
            Dislike dislike17 = createDislike("가지");
            em.persist(dislike17);
            Dislike dislike18 = createDislike("브로콜리");
            em.persist(dislike18);
        }

        private Dislike createDislike(String name) {
            Dislike dislike = new Dislike();
            dislike.changeName(name);
            return dislike;
        }
    }
}
