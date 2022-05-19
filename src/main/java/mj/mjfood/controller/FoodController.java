package mj.mjfood.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mj.mjfood.config.BaseResponse;
import mj.mjfood.dto.GetFoodRes;
import mj.mjfood.dto.RecommendFoodRes;
import mj.mjfood.entity.Food;
import mj.mjfood.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@RequestMapping("/api/foods")
@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodService foodService;

    @ApiOperation("음식 상세정보 페이지 조회")
    @GetMapping("/{foodId}")
    public BaseResponse<GetFoodRes> getFood(@PathVariable Long foodId) {
        Food food = foodService.findOne(foodId);
        GetFoodRes getFoodRes = new GetFoodRes(food);
        return new BaseResponse<>(getFoodRes);
    }

    @ApiOperation("이름 검색")
    @GetMapping("/")
    public BaseResponse<List<RecommendFoodRes>> searchFood(@RequestParam String keyword) {
        List<Food> foods = foodService.findFoods(keyword);
        List<RecommendFoodRes> res = foods.stream()
                .map(RecommendFoodRes::new)
                .collect(toList());
        return new BaseResponse<>(res);
    }
}
