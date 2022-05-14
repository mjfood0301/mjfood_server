package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Food;
import mj.mjfood.entity.FoodDislike;
import mj.mjfood.entity.FoodTag;
import mj.mjfood.repository.FoodDislikeRepository;
import mj.mjfood.repository.FoodRepository;
import mj.mjfood.repository.FoodTagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodDislikeRepository foodDislikeRepository;
    private final FoodTagRepository foodTagRepository;

    @Transactional
    public Long createFood(String name, String image, String info, List<Long> foodDislikesId, List<Long> foodTagsId) {

        //엔티티 조회
        List<FoodDislike> foodDislikes = foodDislikesId.stream()
                .map(foodDislikeRepository::findOne)
                .collect(toList());
        List<FoodTag> foodTags = foodTagsId.stream()
                .map(foodTagRepository::findOne)
                .collect(toList());

        //음식 생성
        Food food = Food.createFood(name, image, info, foodDislikes, foodTags);

        //음식 저장
        foodRepository.save(food);

        return food.getId();
    }

}
