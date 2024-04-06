package ee.eek.booking.web;

import ee.eek.booking.dto.BookingDto;
import ee.eek.booking.dto.CreateBookingRequest;
import ee.eek.booking.dto.UpdateBooking;
import ee.eek.booking.dto.UpdateStatusRequest;
import ee.eek.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public BookingDto create(@RequestBody CreateBookingRequest request){
        return bookingService.createBooking(request);
    }

    @GetMapping("/{id}")
    public BookingDto findById(@PathVariable Long id){
        return bookingService.findById(id);
    }

    @PutMapping("/{id}")
    public BookingDto update(@PathVariable Long id, @RequestBody BookingDto request) {
        return bookingService.updateBooking(id, request);
    }
    @PutMapping
    public BookingDto update(@RequestBody UpdateBooking request) {
        return null;
    }
}
