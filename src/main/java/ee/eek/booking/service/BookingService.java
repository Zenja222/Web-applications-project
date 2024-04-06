package ee.eek.booking.service;

import ee.eek.booking.dto.BookingDto;
import ee.eek.booking.dto.CreateBookingRequest;
import ee.eek.booking.dto.RoomDto;
import ee.eek.booking.mapper.BookingMapper;
import ee.eek.booking.model.Booking;
import ee.eek.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingDto createBooking(CreateBookingRequest createBookingRequest){
//        if(/*roomservice status = true*/) {
            Booking booking = BookingMapper.toEntity(createBookingRequest);
            //cahnge room service status
        // roomService.changeAvailabilityStatus(booking.getRoomId(), new RoomDto());
            return BookingMapper.toDto(bookingRepository.save(booking));
//        }
    }

    public BookingDto updateBooking(Long id, BookingDto bookingDto){
        Booking booking = BookingMapper.updateEntity(bookingDto, requireBooking(id));
        return BookingMapper.toDto(bookingRepository.save(booking));
    }

    //CREAT BOOKING -> WHEN CREATING BOOKING CHANGE BOOKING ID STATUS TO FALSE

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

    //deleteBooking

    private Booking requireBooking(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("booking not found"));
    }

}