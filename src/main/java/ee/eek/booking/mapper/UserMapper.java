package ee.eek.booking.mapper;

import ee.eek.booking.dto.CreateUserRequest;
import ee.eek.booking.dto.UserDto;
import ee.eek.booking.model.User;

public class UserMapper {

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public static User toEntity(CreateUserRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return user;
    }
}
