package ee.eek.booking.dto;

import lombok.Data;

@Data
public class RoomDto {
    private Long id;
    private String roomType;
    private double price;
}