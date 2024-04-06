package ee.eek.booking.repository;

import ee.eek.booking.model.Booking;
import ee.eek.booking.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findAll();
    List<Room> findRoomsByStatus(boolean status);

}