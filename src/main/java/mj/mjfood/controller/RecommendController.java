package mj.mjfood.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mj.mjfood.config.BaseException;
import mj.mjfood.config.BaseResponse;
import mj.mjfood.dto.RecommendFoodRes;
import mj.mjfood.entity.Food;
import mj.mjfood.service.FoodTagService;
import mj.mjfood.utils.JwtService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static mj.mjfood.config.BaseResponseStatus.EMPTY_JWT;
import static mj.mjfood.config.BaseResponseStatus.INVALID_USER_JWT;

@RequestMapping("/api/recommend")
@RequiredArgsConstructor
@RestController
public class RecommendController {

    private final FoodTagService foodTagService;
    private final JwtService jwtService;

    @ApiOperation("음식 추천")
    @GetMapping("/")
    public BaseResponse<List<RecommendFoodRes>> recommendFood(@RequestParam List<Long> tags) {
        try {
            Long userIdByJwt = jwtService.getUserIdx();

            List<Food> recommend = foodTagService.recommend(tags);

            List<RecommendFoodRes> res = recommend.stream()
                    .map(RecommendFoodRes::new)
                    .collect(Collectors.toList());

            return new BaseResponse<>(res);
        } catch (BaseException e) {
            return new BaseResponse<>(EMPTY_JWT);
        }
    }
}
