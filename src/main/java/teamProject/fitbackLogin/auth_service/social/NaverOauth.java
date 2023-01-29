
package teamProject.fitbackLogin.auth_service.social;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NaverOauth implements SocialOauth{

    @Value("${spring.security.oauth2.client.provider.naver.authorization-uri}")
    private String NAVER_SNS_BASE_URL;
    @Value("${spring.security.oauth2.client.registration.naver.redirect-uri}")
    private String NAVER_SNS_CALLBACK_URL;
    @Value("${spring.security.oauth2.client.registration.naver.client-id}")
    private String NAVER_SNS_CLIENT_ID;
    @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
    private String NAVER_SNS_CLIENT_SECRET;
    @Value("${spring.security.oauth2.client.provider.naver.token-uri}")
    private String NAVER_SNS_TOKEN_BASE_URL;
    @Value("${spring.security.oauth2.client.registration.naver.scope}")
    private String NAVER_SNS_SCOPE;
    private final static String SESSION_STATE = "oauth_state";

    @Override
    public String getOauthRedirectURL() {


        Map<String, Object> params = new HashMap<>();
        params.put("response_type", "code");
        params.put("client_id", NAVER_SNS_CLIENT_ID);
        params.put("state", "oauth_state");
        params.put("redirect_uri", NAVER_SNS_CALLBACK_URL);


        String parameterString = params.entrySet().stream()
                .map(x -> x.getKey() + "=" + x.getValue())
                .collect(Collectors.joining("&"));

        return NAVER_SNS_BASE_URL + "?" + parameterString;
    }

    @Override
    public String requestAccessToken(String code) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            public boolean hasError(ClientHttpResponse response) throws IOException {
                HttpStatus statusCode = response.getStatusCode();
                return statusCode.series() == HttpStatus.Series.SERVER_ERROR;
            }
        });

        Map<String, Object> params = new HashMap<>();
        params.put("grant_type", "authorization_code");
        params.put("client_id", NAVER_SNS_CLIENT_ID);
        params.put("client_secret", NAVER_SNS_CLIENT_SECRET);
        params.put("code", code);
        params.put("state", "oauth_state");


        ResponseEntity<String> responseEntity = restTemplate.postForEntity(NAVER_SNS_TOKEN_BASE_URL, params, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return "네이버 로그인 요청 처리 실패";
    }
}
