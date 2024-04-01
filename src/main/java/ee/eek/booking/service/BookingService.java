package ee.eek.booking.service;

import ee.eek.booking.dto.BookingDto;
import ee.eek.booking.mapper.BookingMapper;
import ee.eek.booking.model.Booking;
import ee.eek.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class BookingService {

    private final BookingRepository bookingRepository;


    public BookingDto createBooking(BookingDto bookingDto){
        Booking booking = BookingMapper.toEntity(bookingDto);
        return BookingMapper.toDto(bookingRepository.save(booking));
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

    //deleteBooking

    private Booking requireBooking(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("booking not found"));
    }

}