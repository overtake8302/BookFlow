package io.elice.shoppingmall.user.controller;

<<<<<<< HEAD
import io.elice.shoppingmall.user.model.JoinDto;
import io.elice.shoppingmall.user.model.LoginDto;
import io.elice.shoppingmall.user.model.User;
=======
import io.elice.shoppingmall.user.model.dto.JoinDto;
import io.elice.shoppingmall.user.model.dto.LoginDto;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
import io.elice.shoppingmall.user.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
<<<<<<< HEAD
    public void login(@Valid @RequestBody LoginDto loginDto) {
        //Spring Security의 filter chain에서 자동으로 처리
    }

    @PostMapping("/join")
    public void join(@RequestBody JoinDto joinDto) {
        authService.join(joinDto);
=======
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
        //Spring Security의 filter chain에서 자동으로 처리
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody JoinDto joinDto) {
        return new ResponseEntity<>(authService.join(joinDto), HttpStatus.CREATED);
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
    }
}
