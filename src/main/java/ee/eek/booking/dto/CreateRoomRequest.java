package ee.eek.booking.dto;

import lombok.Data;

@Data
public class CreateRoomRequest {
    private String roomType;
    private double price;
    private boolean status;
}
