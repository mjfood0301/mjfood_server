package mj.mjfood.controller;

import lombok.RequiredArgsConstructor;
import mj.mjfood.service.UserDislikeService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user-dislikes")
@RequiredArgsConstructor
@RestController
public class UserDislikeController {

    private final UserDislikeService userDislikeService;

}
