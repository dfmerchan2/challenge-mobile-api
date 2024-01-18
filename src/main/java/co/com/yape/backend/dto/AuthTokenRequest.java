package co.com.yape.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthTokenRequest {
    private String username;
    private String password;
}
