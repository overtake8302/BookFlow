package io.elice.shoppingmall.user.jwt;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtServiceImpl implements JwtService {

    @Override
    public String createAccessToken(String username) {
        return null;
    }

    @Override
    public Optional<String> getAccessTokenUsername() {
        return Optional.empty();
    }

    @Override
    public Optional<String> getAccessTokenRole() {
        return Optional.empty();
    }

    @Override
    public void sendAccessToken(HttpServletResponse response, String accessToken) {

    }

    @Override
    public void setAccessTokenHeader(HttpServletResponse response, String accessToken) {

    }

    @Override
    public boolean isTokenExpired(String token) {
        return false;
    }
}
