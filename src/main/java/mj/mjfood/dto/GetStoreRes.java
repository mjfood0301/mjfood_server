package mj.mjfood.dto;

import lombok.Data;
import mj.mjfood.entity.Store;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Data
public class GetStoreRes {

    private Long storeId;
    private String name;
    private String image;
    private BigDecimal locationX;
    private BigDecimal locationY;
    private int likesCount;
    private List<ReviewDto> reviews;

    public GetStoreRes(Store store) {
        this.storeId = store.getId();
        this.name = store.getName();
        this.image = store.getImage();
        this.locationX = store.getLocationX();
        this.locationY = store.getLocationY();
        this.likesCount = store.getTotalLikes();
        this.reviews = store.getReviews()
                .stream()
                .map(ReviewDto::new)
                .collect(toList());
    }
}
