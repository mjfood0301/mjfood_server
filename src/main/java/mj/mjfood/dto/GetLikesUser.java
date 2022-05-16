package mj.mjfood.dto;

import lombok.Data;
import mj.mjfood.entity.Likes;

@Data
public class GetLikesUser {

    private Long storeId;
    private String name;
    private String image;

    public GetLikesUser(Likes likes) {
        this.storeId = likes.getStore().getId();
        this.name = likes.getStore().getName();
        this.image = likes.getStore().getImage();
    }
}
