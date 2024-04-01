package ee.eek.booking.repository;

import ee.eek.booking.model.Booking;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAll();

    @Query("SELECT * FROM booking b " +
            "WHERE b.checkInDate <= :checkOutDate " +
            "AND b.checkOutDate >= :checkInDate")
    List<Booking> findAvailableRooms(@Param("checkInDate") LocalDate checkInDate,
                                     @Param("checkOutDate") LocalDate checkOutDate);
    }
