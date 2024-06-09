package io.elice.shoppingmall.user.service;

import io.elice.shoppingmall.user.jwt.JwtService;
import io.elice.shoppingmall.user.repository.RefreshRepository;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshService {
    private final JwtService jwtService;
    private final RefreshRepository refreshRepository;

    public void reissueTokens(HttpServletRequest request, HttpServletResponse response){
        String refresh = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("refresh")) {
                refresh = cookie.getValue();
            }
        }

        if (refresh == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        try {
            jwtService.isTokenExpired(refresh);
        } catch (ExpiredJwtException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String subject = jwtService.getTokenSubject(refresh);
        if (!subject.equals("refresh")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        Boolean isExist = refreshRepository.existsByRefresh(refresh);
        if (!isExist) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String username = jwtService.getTokenUsername(refresh);
        String role = jwtService.getTokenRole(refresh);

        String newAccess = jwtService.createToken("access", username, role, 86400000L); //1일
        String newRefresh = jwtService.createToken("refresh", username, role, 86400000L*7); //7일

        refreshRepository.deleteByRefresh(refresh);
        jwtService.saveRefreshTokenDB(username, newRefresh, 86400000L*7);

        response.setHeader("access", newAccess);
        response.addCookie(jwtService.createCookie("refresh", newRefresh));
    }
}
