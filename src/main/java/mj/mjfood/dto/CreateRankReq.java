package mj.mjfood.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateRankReq {
    @ApiModelProperty(notes = "이전에 선택된 음식ID입니다. 처음이면, 0을 넣어주세요.")
    private Long previousFoodId;
    @ApiModelProperty(notes = "바뀔 오늘의 음식ID입니다.")
    private Long changedFoodId;
}
