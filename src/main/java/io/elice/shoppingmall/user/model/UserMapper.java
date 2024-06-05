package io.elice.shoppingmall.user.model;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    default User JoinDtoToUser(JoinDto joinDto) {
        User user = new User();
        user.setUsername(joinDto.getUsername());
        user.setName(joinDto.getName());
        user.setPhoneNumber(joinDto.getPhoneNumber());
        return user;
    }
}
