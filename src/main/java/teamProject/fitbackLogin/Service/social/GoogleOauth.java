package teamProject.fitbackLogin.Service.social;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GoogleOauth implements SocialOauth{
    @Value("${spring.security.oauth2.client.registration.google.url}")
    private String GOOGLE_SNS_BASE_URL;
    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String GOOGLE_SNS_CLIENT_ID;
    @Value("${spring.security.oauth2.client.registration.google.callback.url}")
    private String GOOGLE_SNS_CALLBACK_URL;
    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String GOOGLE_SNS_CLIENT_SECRET;

    @Override
    public String getOauthRedirectURL() {
        Map<String, Object> params = new HashMap<>();
        params.put("scope", "profile");
        params.put("response_type", "code");
        params.put("client_id", GOOGLE_SNS_CLIENT_ID);
        params.put("redirect_uri", GOOGLE_SNS_CALLBACK_URL);

        String parameterString = params.entrySet().stream()
                .map(x -> x.getKey() + "=" + x.getValue())
                .collect(Collectors.joining("&"));

        return GOOGLE_SNS_BASE_URL + "?" + parameterString;
    }

    @Override
    public String requestAccessToken(String code) {
        return "";
    }
}
