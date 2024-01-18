package co.com.yape.backend.dto;

import lombok.Data;

@Data
public class AuthTokenResponse {
    private String token;
    private String reason;
}
