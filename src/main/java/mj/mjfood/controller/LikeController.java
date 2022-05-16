package mj.mjfood.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mj.mjfood.config.BaseException;
import mj.mjfood.config.BaseResponse;
import mj.mjfood.dto.GetLikesUser;
import mj.mjfood.entity.Likes;
import mj.mjfood.service.LikesService;
import mj.mjfood.utils.JwtService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static mj.mjfood.config.BaseResponseStatus.EMPTY_JWT;
import static mj.mjfood.config.BaseResponseStatus.INVALID_USER_JWT;

@RequestMapping("/api/likes")
@RequiredArgsConstructor
@RestController
public class LikeController {

    private final LikesService likesService;
    private final JwtService jwtService;

    @ApiOperation("가게 찜하기")
    @PostMapping("/{userId}/{storeId}")
    public BaseResponse<String> createLikes(@PathVariable(value = "userId") Long userId, @PathVariable(value = "storeId") Long storeId) {
        try {
            Long userIdByJwt = jwtService.getUserIdx();

            if (!Objects.equals(userId, userIdByJwt)) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }

            Long likesId = likesService.createLikes(userId, storeId);
            return new BaseResponse<>("");
        } catch (BaseException e) {
            return new BaseResponse<>(EMPTY_JWT);
        }
    }

    @ApiOperation("내 찜 목록 조회")
    @GetMapping("/{userId}")
    public BaseResponse<List<GetLikesUser>> getLikesUser(@PathVariable Long userId) {
        try {
            Long userIdByJwt = jwtService.getUserIdx();

            if (!Objects.equals(userId, userIdByJwt)) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }

            List<Likes> likes =  likesService.findByUser(userId);
            List<GetLikesUser> getLikesUsers = likes.stream()
                    .map(GetLikesUser::new)
                    .collect(toList());
            return new BaseResponse<>(getLikesUsers);
        } catch (BaseException e) {
            return new BaseResponse<>(EMPTY_JWT);
        }
    }

    @ApiOperation("찜 취소")
    @PatchMapping("status/{userId}/{storeId}")
    public BaseResponse<String> deleteLikes(@PathVariable(value = "userId") Long userId, @PathVariable(value = "storeId") Long storeId) {
        try {
            Long userIdByJwt = jwtService.getUserIdx();

            if (!Objects.equals(userId, userIdByJwt)) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }

            likesService.deleteLikes(userId, storeId);
            return new BaseResponse<>("");
        } catch (BaseException e) {
            return new BaseResponse<>(EMPTY_JWT);
        }
    }

}
