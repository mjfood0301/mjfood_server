package mj.mjfood.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mj.mjfood.config.BaseResponse;
import mj.mjfood.dto.GetFoodRes;
import mj.mjfood.entity.Food;
import mj.mjfood.service.FoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
