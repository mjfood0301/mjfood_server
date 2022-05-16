package mj.mjfood.dto;

import lombok.Data;
import mj.mjfood.entity.Review;

@Data
public class ReviewDto {

    private Long reviewId;
    private String userName;
    private String image;
    private int rate;
    private String content;

    public ReviewDto(Review review) {
        this.reviewId = review.getId();
        this.userName = review.getUser().getName();
        this.image = review.getUser().getImage();
        this.rate = review.getRate();
        this.content = review.getContent();
    }
}
