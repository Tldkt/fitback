package teamProject.fitbackLogin.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import teamProject.fitbackLogin.Service.social.SocialOauth;
import teamProject.fitbackLogin.helper.constants.SocialLoginType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OauthService {
    //필드에서 @RequiredArgsConstructor를 통해 SocialOauth 타입의 객체들이 List 형태로 Injection 되도록 필드를 List 타입으로 수정
    private final List<SocialOauth> socialOauthList;
    private final HttpServletResponse response;

    public void request(SocialLoginType socialLoginType) {
        SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);
        String redirectURL = socialOauth.getOauthRedirectURL();
        try {
            response.sendRedirect(redirectURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String requestAccessToken(SocialLoginType socialLoginType, String code) {
        SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);
        return socialOauth.requestAccessToken(code);
    }

    //SocialLoginType에 맞는 SocialOauth 객체를 반환하는 findSocialOauthByType 메소드
    //각 request, requestAccessToken 메소드에서 SocialLoginType에 맞는 SocialOauth 클래스를 findSocialOauthByType 함수를 통해 초기화
    private SocialOauth findSocialOauthByType(SocialLoginType socialLoginType) {
        return socialOauthList.stream()
                .filter(x -> x.type() == socialLoginType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("알 수 없는 SocialLoginType 입니다."));
    }
}