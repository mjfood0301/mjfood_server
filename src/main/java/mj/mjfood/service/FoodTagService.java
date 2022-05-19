package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.Food;
import mj.mjfood.entity.FoodTag;
import mj.mjfood.entity.Tag;
import mj.mjfood.repository.FoodTagRepository;
import mj.mjfood.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FoodTagService {

    private final FoodTagRepository foodTagRepository;
    private final TagRepository tagRepository;

    public List<FoodTag> findByTag(Long tagId) {
        // 엔티티 조회
        Tag tag = tagRepository.findOne(tagId);

        return foodTagRepository.findByTag(tag);
    }

    public List<Food> recommend(List<Long> tagIds) {

        List<Tag> tags = tagIds.stream()
                .map(tagRepository::findOne)
                .collect(toList());

        List<FoodTag> foodTags = foodTagRepository.findByTag(tags.get(0));

        List<Food> foods = foodTags.stream()
                .map(FoodTag::getFood)
                .collect(toList());

        List<Food> res = new ArrayList<>();

        for (Food food : foods) {
            List<Tag> tagList = food.getFoodTags().stream()
                    .map(FoodTag::getTag)
                    .collect(toList());
            if(tagList.containsAll(tags)){
                res.add(food);
            }
        }

        return res;

    }
}
