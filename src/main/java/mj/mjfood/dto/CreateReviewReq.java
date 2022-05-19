package mj.mjfood.dto;

import lombok.Data;

@Data
public class CreateReviewReq {
    private Long userId;
    private Long storeId;
    private int rate;
    private String content;
}
