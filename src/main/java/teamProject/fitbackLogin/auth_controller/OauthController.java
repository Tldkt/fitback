package teamProject.fitbackLogin.auth_controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import teamProject.fitbackLogin.auth_service.OauthService;
import teamProject.fitbackLogin.helper.constants.SocialLoginType;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class OauthController {

    private final OauthService oauthService;
     //사용자로부터 SNS 로그인 요청을 Social Login Type 을 받아 처리
     //@param socialLoginType (GOOGLE, NAVER)

    @GetMapping(value = "/{socialLoginType}")
    public void socialLoginType(@PathVariable(name = "socialLoginType") SocialLoginType socialLoginType) {
        log.info(">> 사용자로부터 SNS 로그인 요청을 받음 :: {} Social Login", socialLoginType);
        oauthService.request(socialLoginType);
    }

    //Social Login API Server 요청에 의한 callback 을 처리
    @GetMapping(value = "/{socialLoginType}/callback")
    public String callback(@PathVariable(name = "socialLoginType") SocialLoginType socialLoginType,
                           @RequestParam(name = "code") String code) {  //API Server 로부터 넘어오는 code

        log.info(">> 소셜 로그인 API 서버로부터 받은 code :: {}", code);

        //SNS Login 요청 결과로 받은 Json 형태의 String 문자열 (access_token, refresh_token 등)
        return oauthService.requestAccessToken(socialLoginType, code);
    }

}
