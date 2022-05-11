package mj.mjfood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import mj.mjfood.entity.UserDislike;

@Data
@AllArgsConstructor
public class UserDislikeDto {

    private long userDislikeId;
    private String name;

    public UserDislikeDto(UserDislike userDislike) {
        this.userDislikeId = userDislike.getId();
        this.name = userDislike.getDislike().getName();
    }
}
