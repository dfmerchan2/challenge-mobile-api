package co.com.yape.backend.dto.builder;

import co.com.yape.backend.dto.AuthTokenRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthTokenRequestBuilder {

    public static AuthTokenRequest authTokenRequest(String username, String password) {
        return AuthTokenRequest.builder()
                .username(username)
                .password(password)
                .build();
    }
}