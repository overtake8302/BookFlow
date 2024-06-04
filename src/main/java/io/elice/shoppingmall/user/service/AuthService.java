package io.elice.shoppingmall.user.service;

import io.elice.shoppingmall.user.model.User;
import io.elice.shoppingmall.user.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public void join(User user) {
        User res = authRepository.save(user);
    }
}
