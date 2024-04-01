package ee.eek.booking.mapper;

import ee.eek.booking.dto.UserDto;
import ee.eek.booking.model.User;

public class UserMapper {

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(userDto.getUsername());
        userDto.setPassword(userDto.getPassword());
        userDto.setRole(userDto.getRole());
        return userDto;
    }

    public static User toEntity(UserDto userDto){
        User user = new User();
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setRole(user.getRole());
        user.setId(user.getId());
        return user;
    }
}
