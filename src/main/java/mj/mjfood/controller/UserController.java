package mj.mjfood.controller;

import lombok.RequiredArgsConstructor;
import mj.mjfood.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


}
