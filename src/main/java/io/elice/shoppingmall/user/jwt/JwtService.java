package io.elice.shoppingmall.user.jwt;

import jakarta.servlet.http.HttpServletResponse;

import java.util.Optional;

public interface JwtService {
    String createAccessToken(String username);
    Optional<String> getAccessTokenUsername();
    Optional<String> getAccessTokenRole();
    void sendAccessToken(HttpServletResponse response, String accessToken);
    void setAccessTokenHeader(HttpServletResponse response, String accessToken);
    boolean isTokenExpired(String token);
}
