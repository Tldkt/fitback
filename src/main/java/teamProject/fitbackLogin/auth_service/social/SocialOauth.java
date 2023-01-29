package teamProject.fitbackLogin.auth_service.social;

import teamProject.fitbackLogin.helper.constants.SocialLoginType;

public interface SocialOauth {
    //각 소셜 로그인 페이지로 redirect할 URL build
    //사용자로부터 로그인 요청을 받아 소셜 로그인 서버 인증용 코드 요청
    String getOauthRedirectURL();

    //API Server로부터 받은 code를 활용하여 사용자 인증 정보 요청
    //API 서버로 부터 응답받은 Json 형태의 결과를 string으로 반환
    String requestAccessToken(String code);

    //OauthService 에서 중복되던 코드 모아넣기
    default SocialLoginType type() {
        if (this instanceof GoogleOauth) {
            return SocialLoginType.GOOGLE;
        } else if (this instanceof NaverOauth) {
            return SocialLoginType.NAVER;
        } else {
            return null;
        }
    }
}
