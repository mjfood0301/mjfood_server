package mj.mjfood.controller;

import mj.mjfood.config.dto.OauthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthController {

    @GetMapping("/auth")
    public OauthResponse jwtResponse(@RequestParam String jwt, @RequestParam Long id) {
        return new OauthResponse(id, jwt);
    }
}