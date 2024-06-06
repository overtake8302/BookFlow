package io.elice.shoppingmall.user.service;

import io.elice.shoppingmall.user.exception.UserNotFoundException;
import io.elice.shoppingmall.user.model.User;
import io.elice.shoppingmall.user.model.UserMapper;
import io.elice.shoppingmall.user.model.dto.AdminPostDto;
import io.elice.shoppingmall.user.model.dto.AdminRolePutDto;
import io.elice.shoppingmall.user.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final UserMapper userMapper;

    public List<AdminPostDto> userFindAll() {
        List<User> userList = adminRepository.findByUsernameAll();
        return userMapper.UserListToAdminPostDtoList(userList);
    }

    public void userRoleUpdate(AdminRolePutDto adminRolePutDto) {
        if (!adminRepository.existsById(adminRolePutDto.getId())) {
            throw new UserNotFoundException("사용자를 찾을 수 없습니다.");
        }

        if (User.Role.USER.getTitle().equals(adminRolePutDto.getRole()))
            adminRolePutDto.setRole(User.Role.USER.getKey());
        else if (User.Role.ADMIN.getTitle().equals(adminRolePutDto.getRole()))
            adminRolePutDto.setRole(User.Role.ADMIN.getKey());
        else {
            throw new RuntimeException("권한 예외 발생");
        }

        User user = userMapper.AdminRolePutDtoToUser(adminRolePutDto);
        adminRepository.save(user);
    }
}
