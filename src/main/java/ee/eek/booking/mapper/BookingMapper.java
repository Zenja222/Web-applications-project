package ee.eek.booking.mapper;

import ee.eek.booking.dto.BookingDto;
import ee.eek.booking.dto.CreateBookingRequest;
import ee.eek.booking.model.Booking;


public class BookingMapper {

        public static BookingDto toDto(Booking booking) {
            BookingDto bookingDto = new BookingDto();
            bookingDto.setCheckInDate(booking.getCheckInDate());
            bookingDto.setCheckOutDate(booking.getCheckOutDate());
            bookingDto.setGuestId(booking.getGuestId());
            bookingDto.setId(booking.getId());
            bookingDto.setRoomId(booking.getRoomId());
            return bookingDto;
        }

        public static Booking toEntity(CreateBookingRequest request){
            Booking booking = new Booking();
            booking.setCheckOutDate(request.getCheckOutDate());
            booking.setCheckInDate(request.getCheckInDate());
            booking.setGuestId(request.getGuestId());
            booking.setRoomId(request.getRoomId());
            return booking;
        }

        public static Booking updateEntity(BookingDto source, Booking target) {
            target.setCheckInDate(source.getCheckInDate());
            target.setCheckOutDate(source.getCheckOutDate());
            target.setRoomId(source.getRoomId());
            target.setGuestId(source.getGuestId());
            return target;
        }

}
