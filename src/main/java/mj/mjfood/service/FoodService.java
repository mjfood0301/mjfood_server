package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.*;
import mj.mjfood.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final DislikeRepository dislikeRepository;
    private final TagRepository tagRepository;

    @Transactional
    public Long createFood(String name, String image, String info, List<Long> dislikesId, List<Long> tagsId) {

        //엔티티 조회
        List<Dislike> dislikes = dislikesId.stream()
                .map(dislikeRepository::findOne)
                .collect(toList());
        List<Tag> tags = tagsId.stream()
                .map(tagRepository::findOne)
                .collect(toList());

        //FoodDislike 생성
        List<FoodDislike> foodDislikes = dislikes.stream()
                .map(FoodDislike::createFoodDislike)
                .collect(toList());

        //FoodTag 생성
        List<FoodTag> foodTags = tags.stream()
                .map(FoodTag::createFoodTag)
                .collect(toList());

        //음식 생성
        Food food = Food.createFood(name, image, info, foodDislikes, foodTags);

        //음식 저장
        foodRepository.save(food);

        return food.getId();
    }

    public Food findOne(Long foodId) {
        return foodRepository.findOne(foodId);
    }

}
