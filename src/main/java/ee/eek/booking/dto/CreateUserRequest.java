package ee.eek.booking.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String password;
}
