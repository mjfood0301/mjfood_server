package mj.mjfood.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import mj.mjfood.entity.Status;
import mj.mjfood.entity.User;
import mj.mjfood.entity.UserDislike;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Data
@AllArgsConstructor
public class GetUserRes {

    private Long userId;
    private String image;
    private String name;
    private String email;
    private List<UserDislikeDto> userDislikes;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private Status status;

    public GetUserRes(User user) {
        this.userId = user.getId();
        this.image = user.getImage();
        this.name = user.getName();
        this.email = user.getEmail();
        this.userDislikes = user.getUserDislikes().stream()
                .map(UserDislikeDto::new)
                .collect(toList());
        this.createAt = user.getCreateAt();
        this.updateAt = user.getUpdateAt();
        this.status = user.getStatus();
    }
}
