package ee.eek.booking.service;

import ee.eek.booking.dto.BookingDto;
import ee.eek.booking.dto.CreateBookingRequest;
import ee.eek.booking.mapper.BookingMapper;
import ee.eek.booking.model.Booking;
import ee.eek.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Service
public class BookingService {
    
    private final BookingRepository bookingRepository;

    public BookingDto createBooking(CreateBookingRequest createBookingRequest){
        Long roomId = createBookingRequest.getRoomId();
        LocalDate checkInDate = createBookingRequest.getCheckInDate();
        LocalDate checkOutDate = createBookingRequest.getCheckOutDate();
        if(isRoomAvailable(roomId,checkInDate,checkOutDate)) {
            Booking booking = BookingMapper.toEntity(createBookingRequest);
            return BookingMapper.toDto(bookingRepository.save(booking));
        } else {
            BookingDto bookingDto = new BookingDto();
            bookingDto.setErrorMessage("The room is not available at the specific time");
            return bookingDto;
        }
    }

    public BookingDto updateBooking(Long id, BookingDto bookingDto){
        Booking booking = BookingMapper.updateEntity(bookingDto, requireBooking(id));
        return BookingMapper.toDto(bookingRepository.save(booking));
    }

    public List<BookingDto> getAll(){
        return bookingRepository.findAll()
                .stream()
                .map(BookingMapper::toDto)
                .toList();
    }

    public BookingDto findById(Long id){
        Booking booking = requireBooking(id);
        return BookingMapper.toDto(booking);
    }

    public boolean isRoomAvailable(Long roomId, LocalDate checkInDate, LocalDate checkOutDate){
        List<Booking> overlappingBookings = bookingRepository.findOverlappingBookings(roomId, checkInDate, checkOutDate);
        return overlappingBookings.isEmpty();
    }

    public void delete(Long id){
        Booking booking = requireBooking(id);
        bookingRepository.delete(booking);
    }

    private Booking requireBooking(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("booking not found"));
    }

}