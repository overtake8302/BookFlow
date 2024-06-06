package io.elice.shoppingmall.user.controller;

import io.elice.shoppingmall.user.model.dto.JoinDto;
import io.elice.shoppingmall.user.model.dto.LoginDto;
import io.elice.shoppingmall.user.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginDto loginDto) {
        //Spring Security의 filter chain에서 자동으로 처리
    }

    @PostMapping("/join")
    public void join(@RequestBody JoinDto joinDto) {
        authService.join(joinDto);
    }
}
