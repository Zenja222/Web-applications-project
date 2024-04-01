package ee.eek.booking.repository;

import ee.eek.booking.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}