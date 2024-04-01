package ee.eek.booking.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDto {
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private Long guestId; // ????
}
