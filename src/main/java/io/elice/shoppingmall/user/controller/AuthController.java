package io.elice.shoppingmall.user.controller;

import io.elice.shoppingmall.user.model.User;
import io.elice.shoppingmall.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public void login() {
        //Spring Security의 filter chain에서 자동으로 처리
    }

    @PostMapping("/join")
    public void join(User user) {
        user.setRole(User.Role.USER.getKey());
        user.setUsername(user.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        authService.join(user);
    }
}
