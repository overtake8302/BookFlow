package io.elice.shoppingmall.user.jwt;

import jakarta.servlet.http.Cookie;

public interface JwtService {
    String createToken(String subject, String username, String role, Long expiredMs);
    String getTokenSubject(String token);
    String getTokenUsername(String token);
    String getTokenRole(String token);
    boolean isTokenExpired(String token);
    void saveRefreshTokenDB(String username, String refresh, Long expiredMs);
    Cookie createCookie(String key, String value);
}
