package mj.mjfood.dto;

import lombok.Data;
import mj.mjfood.entity.Food;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Data
public class RecommendFoodRes {
    private Long foodId;
    private String name;
    private String image;
    private List<TagDto> tagList;

    public RecommendFoodRes(Food food) {
        this.foodId = food.getId();
        this.name = food.getName();
        this.image = food.getImage();
        this.tagList = food.getFoodTags()
                .stream()
                .map(t -> new TagDto(t.getTag()))
                .collect(toList());
    }
}
