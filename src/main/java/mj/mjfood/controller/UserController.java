package mj.mjfood.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mj.mjfood.config.BaseException;
import mj.mjfood.config.BaseResponse;
import mj.mjfood.config.BaseResponseStatus;
import mj.mjfood.dto.GetUserRes;
import mj.mjfood.entity.User;
import mj.mjfood.service.UserService;
import mj.mjfood.utils.JwtService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static mj.mjfood.config.BaseResponseStatus.EMPTY_JWT;
import static mj.mjfood.config.BaseResponseStatus.INVALID_USER_JWT;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @ApiOperation(value = "사용자의 싫어하는 것들 추가")
    @PostMapping("/{userId}")
    public BaseResponse<String> createUser(@PathVariable Long userId, @RequestParam List<Long> dislikes) {

        try {
            Long userIdByJwt = jwtService.getUserIdx();

            if (!Objects.equals(userId, userIdByJwt)) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }

            dislikes.forEach(d -> userService.dislike(userIdByJwt, d));
        } catch (BaseException e) {
            return new BaseResponse<>(EMPTY_JWT);
        }

        return new BaseResponse<>("");
    }

    @ApiOperation(value = "사용자 정보 조회")
    @GetMapping("/{userId}")
    public BaseResponse<GetUserRes> getUser(@PathVariable Long userId) {
        try {
            Long userIdByJwt = jwtService.getUserIdx();

            if (!Objects.equals(userId, userIdByJwt)) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }

            User user = userService.findOne(userId);
            GetUserRes res = new GetUserRes(user);

            return new BaseResponse<>(res);
        } catch (BaseException e) {
            return new BaseResponse<>(EMPTY_JWT);
        }

    }

    @ApiOperation(value = "사용자 정보 수정")
    @PatchMapping("/{userId}")
    public BaseResponse<String> updateUser(@PathVariable Long userId, @RequestParam List<Long> dislikes) {
        try {
            Long userIdByJwt = jwtService.getUserIdx();
            if (!Objects.equals(userId, userIdByJwt)) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            userService.updateDislikes(userId, dislikes);
        } catch (BaseException e) {
            return new BaseResponse<>(EMPTY_JWT);
        }

        return new BaseResponse<String>("");
    }


    @ApiOperation(value = "사용자 탈퇴")
    @PatchMapping("/status/{userId}")
    public BaseResponse<String> quitUser(@PathVariable Long userId) {
        try {
            Long userIdByJwt = jwtService.getUserIdx();
            if (!Objects.equals(userId, userIdByJwt)) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            userService.quit(userId);
        } catch (BaseException e) {
            return new BaseResponse<>(EMPTY_JWT);
        }

        return new BaseResponse<String>("");
    }
}
