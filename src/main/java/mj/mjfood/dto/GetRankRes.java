package mj.mjfood.dto;

import lombok.Data;
import mj.mjfood.entity.Ranks;

@Data
public class GetRankRes {
    private Long FoodId;
    private String name;
    private int count;

    public GetRankRes(Ranks ranks) {
        FoodId = ranks.getFood().getId();
        this.name = ranks.getFood().getName();
        this.count = ranks.getCount();
    }
}
