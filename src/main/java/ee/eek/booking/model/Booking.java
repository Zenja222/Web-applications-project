package ee.eek.booking.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
@Data
@Table(name = "booking")
public class Booking {
    @Id
    private Long id;
    private Long guestId; // ?
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
}
