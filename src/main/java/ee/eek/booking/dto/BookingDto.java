package ee.eek.booking.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class BookingDto {
    private long id;
    private Long guestId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String errorMessage;

}
