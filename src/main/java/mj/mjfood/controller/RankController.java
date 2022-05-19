package mj.mjfood.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mj.mjfood.config.BaseException;
import mj.mjfood.config.BaseResponse;
import mj.mjfood.dto.CreateRankReq;
import mj.mjfood.dto.GetRankRes;
import mj.mjfood.entity.Ranks;
import mj.mjfood.service.RankService;
import mj.mjfood.utils.JwtService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.*;
import static mj.mjfood.config.BaseResponseStatus.EMPTY_JWT;
import static mj.mjfood.config.BaseResponseStatus.INVALID_USER_JWT;

@RequestMapping("api/ranks")
@RequiredArgsConstructor
@RestController
public class RankController {

    private final RankService rankService;
    private final JwtService jwtService;

    @ApiOperation("오늘의 선택 등록")
    @PostMapping("/{userId}")
    public BaseResponse<String> createUser(@PathVariable Long userId, @RequestBody CreateRankReq createRankReq) {

        try {
            Long userIdByJwt = jwtService.getUserIdx();

            if (!Objects.equals(userId, userIdByJwt)) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            if (createRankReq.getPreviousFoodId() == 0L) {
                rankService.create(createRankReq.getChangedFoodId());
            }else{
                rankService.update(createRankReq.getPreviousFoodId(), createRankReq.getChangedFoodId());
            }

        } catch (BaseException e) {
            return new BaseResponse<>(EMPTY_JWT);
        }

        return new BaseResponse<>("");
    }

    @ApiOperation("오늘의 선택")
    @GetMapping("/")
    public BaseResponse<List<GetRankRes>> getRankList() {
        List<Ranks> ranks = rankService.getRank();
        List<GetRankRes> res = ranks.stream()
                .map(GetRankRes::new)
                .collect(toList());
        return new BaseResponse<>(res);
    }
}
