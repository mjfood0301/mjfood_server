package mj.mjfood.controller;

import lombok.RequiredArgsConstructor;
import mj.mjfood.config.BaseException;
import mj.mjfood.config.BaseResponse;
import mj.mjfood.dto.CreateReviewReq;
import mj.mjfood.service.ReviewService;
import mj.mjfood.utils.JwtService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static mj.mjfood.config.BaseResponseStatus.EMPTY_JWT;
import static mj.mjfood.config.BaseResponseStatus.INVALID_USER_JWT;

@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;
    private final JwtService jwtService;

    @PostMapping("/")
    public BaseResponse<String> createReview(@RequestBody CreateReviewReq createReviewReq) {
        try {
            Long userIdByJwt = jwtService.getUserIdx();

            if (!Objects.equals(createReviewReq.getUserId(), userIdByJwt)) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }

            reviewService.createReview(createReviewReq);
            return new BaseResponse<>("");
        } catch (BaseException e) {
            return new BaseResponse<>(EMPTY_JWT);
        }
    }
}
