package io.elice.shoppingmall.user.jwt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    // 클라이언트에서 /login 요청시 security에서 클라이언트 요청을 가로챔
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username == null || password == null) {
            log.error("로그인 유효성 오류");
            new RuntimeException("로그인 유효성 오류");
        }
        log.info("로그인 테스트 : " + username + " " + password);

        //username와 password를 authenticationManager에게 전달할때 필요한 객체
        UsernamePasswordAuthenticationToken authToken
                = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authenticate = authenticationManager.authenticate(authToken);
        JwtUserDetails jwtUserDetails = (JwtUserDetails) authenticate.getPrincipal();
        log.info("jwtUserDetails.getUsername() : " + jwtUserDetails.getUsername());
        log.info("jwtUserDetails.getPassword() : " + jwtUserDetails.getPassword());
        log.info("jwtUserDetails.Role() : " + jwtUserDetails.getRole());
        jwtUserDetails
                .getAuthorities()
                .stream()
                .forEach(item ->
                        log.info("jwtUserDetails.getAuthority() : " + item.getAuthority())
                );

        return authenticate;
    }
}
