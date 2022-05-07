package mj.mjfood.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OauthResponse {
    private Long id;
    private String jwt;
}
