package ee.eek.booking.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "room")
public class Room {
    @Id
    private Long id;
    private String roomType;
    private double price;
}
