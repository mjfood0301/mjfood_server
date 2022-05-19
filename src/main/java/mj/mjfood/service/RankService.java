package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Food;
import mj.mjfood.entity.Ranks;
import mj.mjfood.repository.FoodRepository;
import mj.mjfood.repository.RankRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RankService {

    private final RankRepository rankRepository;
    private final FoodRepository foodRepository;

    @Transactional
    public void create(Long changedFoodId) {
        // 엔티티 조회
        Food food = foodRepository.findOne(changedFoodId);
        List<Ranks> ranks = rankRepository.findByFood(food);
        if(ranks.isEmpty()){
            Ranks rank = Ranks.create(food);
            rankRepository.save(rank);
        }else{
            for(Ranks rank : ranks){
                rank.plusCount();
            }
        }
    }

    @Transactional
    public void update(Long previousFoodId, Long changedFoodId) {
        //엔티티 조회
        List<Ranks> previousRanks = getRanks(previousFoodId);
        for (Ranks ranks : previousRanks) {
            ranks.minusCount();
        }
        create(changedFoodId);
    }

    private List<Ranks> getRanks(Long foodId) {
        Food food = foodRepository.findOne(foodId);
        List<Ranks> ranks = rankRepository.findByFood(food);
        return ranks;
    }

    public List<Ranks> getRank() {
        return rankRepository.findByRank();
    }
}
