package io.elice.shoppingmall.user.service;

import io.elice.shoppingmall.user.model.JoinDto;
import io.elice.shoppingmall.user.model.User;
import io.elice.shoppingmall.user.model.UserMapper;
import io.elice.shoppingmall.user.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public void join(JoinDto joinDto) {
        User user = userMapper.JoinDtoToUser(joinDto);
        user.setPassword(passwordEncoder.encode(joinDto.getPassword()));
        user.setRole(User.Role.USER.getKey());

        if (authRepository.existsByUsername(user.getUsername())) {
            new RuntimeException("아이디 중복");
        }

        authRepository.save(user);
    }
}
