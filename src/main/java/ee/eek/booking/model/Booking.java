package ee.eek.booking.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
@Data
@Table(name = "booking")
public class Booking {
    @Id
    private Long id;
    private Long guestId; // ?
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
