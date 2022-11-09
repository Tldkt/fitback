package teamProject.fitbackLogin.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import teamProject.fitbackLogin.Service.social.GoogleOauth;
import teamProject.fitbackLogin.Service.social.NaverOauth;
import teamProject.fitbackLogin.Service.social.SocialOauth;
import teamProject.fitbackLogin.helper.constants.SocialLoginType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OauthService {
    private final GoogleOauth googleOauth;
    private final NaverOauth naverOauth;
    private final HttpServletResponse response;

    public void request(SocialLoginType socialLoginType) {
        String redirectURL;
        switch (socialLoginType) {
            case GOOGLE: {
                redirectURL = googleOauth.getOauthRedirectURL();
            } break;
            case NAVER: {
                redirectURL = naverOauth.getOauthRedirectURL();
            } break;
            default: {
                throw new IllegalArgumentException("알 수 없는 소셜 로그인 형식입니다.");
            }
        }
        try {
            response.sendRedirect(redirectURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String requestAccessToken(SocialLoginType socialLoginType, String code) {
        switch (socialLoginType) {
            case GOOGLE: {
                return googleOauth.requestAccessToken(code);
            }
            case NAVER: {
                return naverOauth.requestAccessToken(code);
            }
            default: {
                throw new IllegalArgumentException("알 수 없는 소셜 로그인 형식입니다.");
            }
        }
    }
}