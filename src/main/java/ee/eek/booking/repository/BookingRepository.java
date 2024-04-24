package ee.eek.booking.repository;

import ee.eek.booking.model.Booking;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAll();
    @Query("SELECT b FROM Booking b WHERE b.room_Id = :roomId AND ((b.check_In_Date < :checkOutDate AND b.check_Out_Date > :checkInDate)" +
            " OR (b.check_In_Date BETWEEN :checkInDate AND :checkOutDate) OR (b.check_Out_Date BETWEEN :checkInDate AND :checkOutDate))")
    List<Booking> findOverlappingBookings(@Param("roomId") Long roomId, @Param("checkInDate") LocalDate checkInDate, @Param("checkOutDate") LocalDate checkOutDate);
}


