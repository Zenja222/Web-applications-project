package ee.eek.booking.service;

import ee.eek.booking.dto.CreateUserRequest;
import ee.eek.booking.dto.UserDto;
import ee.eek.booking.mapper.UserMapper;
import ee.eek.booking.model.User;
import ee.eek.booking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserDto create(CreateUserRequest createUserRequest){
        User user = UserMapper.toEntity(createUserRequest);
        return UserMapper.toDto(userRepository.save(user));
    }

    public UserDto findById(Long id){
        User user = requireUser(id);
        return UserMapper.toDto(user);
    }

    private User requireUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("user not found"));
    }
}
