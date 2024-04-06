package ee.eek.booking.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateBooking {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long guestId;
    private Long roomId;
}
