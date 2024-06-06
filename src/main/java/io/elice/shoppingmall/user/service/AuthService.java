package io.elice.shoppingmall.user.service;

<<<<<<< HEAD
import io.elice.shoppingmall.user.model.JoinDto;
import io.elice.shoppingmall.user.model.User;
import io.elice.shoppingmall.user.model.UserMapper;
import io.elice.shoppingmall.user.repository.AuthRepository;
=======
import io.elice.shoppingmall.user.exception.DuplicateUsernameException;
import io.elice.shoppingmall.user.model.dto.JoinDto;
import io.elice.shoppingmall.user.model.User;
import io.elice.shoppingmall.user.model.UserMapper;
import io.elice.shoppingmall.user.repository.AuthRepository;
import jakarta.annotation.PostConstruct;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

<<<<<<< HEAD
    public void join(JoinDto joinDto) {
=======
    @PostConstruct
    public void adminInit() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setRole(User.Role.ADMIN.getKey());
        user.setName("관리자용 계정");
        authRepository.save(user);
        dummyUser();
    }

    public void dummyUser() {
        User user = new User();
        user.setUsername("user01");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setRole(User.Role.USER.getKey());
        user.setName("홍길동");
        authRepository.save(user);

        user = new User();
        user.setUsername("user02");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setRole(User.Role.USER.getKey());
        user.setName("고미숙");
        authRepository.save(user);

        user = new User();
        user.setUsername("user03");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setRole(User.Role.USER.getKey());
        user.setName("바루스");
        authRepository.save(user);
    }

    public boolean join(JoinDto joinDto) {
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
        User user = userMapper.JoinDtoToUser(joinDto);
        user.setPassword(passwordEncoder.encode(joinDto.getPassword()));
        user.setRole(User.Role.USER.getKey());

        if (authRepository.existsByUsername(user.getUsername())) {
<<<<<<< HEAD
            new RuntimeException("아이디 중복");
        }

        authRepository.save(user);
=======
            throw new DuplicateUsernameException("아이디가 중복 되었습니다");
        }

        return authRepository.save(user) != null ? true : false;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
    }
}
