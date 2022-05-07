package mj.mjfood.config.auth;

import lombok.RequiredArgsConstructor;
import mj.mjfood.entity.User;
import mj.mjfood.service.UserService;
import mj.mjfood.utils.JwtService;
import mj.mjfood.utils.SHA256;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class Oauth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final UserService userService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        String email = getEmail(oAuth2User);

        //엔티티 조회
        List<User> users= userService.findByEmail(email);

        //토큰 생성
        String jwt = jwtService.createJwt(users.get(0).getId());


//        writeTokenResponse(response, jwt);
        String targetUrl = UriComponentsBuilder.fromUriString("/auth")
                .queryParam("jwt",jwt)
                .queryParam("id", users.get(0).getId())
                .build().toUriString();
        getRedirectStrategy().sendRedirect(request,response,targetUrl);

    }

    private String getEmail(OAuth2User oAuth2User) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");

        return (String)kakaoAccount.get("email");
    }

    private void writeTokenResponse(HttpServletResponse response, String jwt) {
        response.setContentType("text/html;charset=UTF-8");

        response.addHeader("Jwt", jwt);
        response.setContentType("application/json;charset=UTF-8");

        try {
            PrintWriter writer = response.getWriter();
            writer.println(jwt);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
