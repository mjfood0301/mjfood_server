package mj.mjfood.controller;

import lombok.RequiredArgsConstructor;
import mj.mjfood.config.BaseResponse;
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

    @GetMapping("/{foodId}")
    public BaseResponse<> getFood(@PathVariable Long foodId) {

    }
}
