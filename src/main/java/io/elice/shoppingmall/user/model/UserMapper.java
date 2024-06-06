package io.elice.shoppingmall.user.model;

import io.elice.shoppingmall.user.model.dto.AdminPostDto;
import io.elice.shoppingmall.user.model.dto.AdminRolePutDto;
import io.elice.shoppingmall.user.model.dto.JoinDto;
import io.elice.shoppingmall.user.model.dto.TotalCountDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    default User JoinDtoToUser(JoinDto joinDto) {
        User user = new User();
        user.setUsername(joinDto.getUsername());
        user.setName(joinDto.getName());
        user.setPhoneNumber(joinDto.getPhoneNumber());
        return user;
    }

    default List<AdminPostDto> UserListToAdminPostDtoList(List<User> userList) {
        List<AdminPostDto> adminPostDtoList = new ArrayList<>();
        for (User user : userList) {
            AdminPostDto dto = new AdminPostDto();
            dto.setUserId(user.getUserId());
            dto.setUsername(user.getUsername());
            dto.setName(user.getName());
            dto.setRole(user.getRole());
            dto.setPhoneNumber(user.getPhoneNumber());
            adminPostDtoList.add(dto);
        }
        return adminPostDtoList;
    }
}
