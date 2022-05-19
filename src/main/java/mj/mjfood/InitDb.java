package mj.mjfood;

import lombok.RequiredArgsConstructor;
import mj.mjfood.dto.CreateMenuDto;
import mj.mjfood.entity.Dislike;
import mj.mjfood.entity.Food;
import mj.mjfood.entity.Tag;
import mj.mjfood.service.FoodService;
import mj.mjfood.service.StoreService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDb {
    
    private final InitService initService;
    
    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
        initService.dbInit3();
        initService.dbInit4();
    }
    

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        private final FoodService fs;
        private final StoreService ss;

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

        public void dbInit2() {
            Tag tag1 = createTag("분식");
            em.persist(tag1);
            Tag tag2 = createTag("매움");
            em.persist(tag2);
            Tag tag3 = createTag("면");
            em.persist(tag3);
            Tag tag4 = createTag("살찜");
            em.persist(tag4);
            Tag tag5 = createTag("건강");
            em.persist(tag5);
        }

        public void dbInit3() {
            List<Long> dislikes = new ArrayList<>();
            dislikes.add(2L);
            dislikes.add(8L);
            List<Long> tags = new ArrayList<>();
            tags.add(19L);
            tags.add(20L);
            tags.add(22L);
            fs.createFood("떡볶이","imageURL","info",dislikes,tags);
        }

        public void dbInit4() {
            List<CreateMenuDto> cmds = new ArrayList<>();
            CreateMenuDto cmd1 = new CreateMenuDto(24L,"떡튀순");
            cmds.add(cmd1);
            ss.createService("까치네 떡볶이", "imageURL",new BigDecimal("3.11111"),new BigDecimal("3.11111"),cmds);
        }

        private Dislike createDislike(String name) {
            Dislike dislike = new Dislike();
            dislike.changeName(name);
            return dislike;
        }

        private Tag createTag(String name) {
            Tag tag = new Tag();
            tag.changeName(name);
            return tag;
        }
    }
}
