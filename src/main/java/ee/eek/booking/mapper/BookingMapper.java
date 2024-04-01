package ee.eek.booking.mapper;

import ee.eek.booking.dto.BookingDto;
import ee.eek.booking.dto.RoomDto;
import ee.eek.booking.model.Booking;
import ee.eek.booking.model.Room;

public class BookingMapper {

        public static BookingDto toDto(Booking booking) {
            BookingDto bookingDto = new BookingDto();
            bookingDto.setCheckInDate(bookingDto.getCheckInDate());
            bookingDto.setCheckOutDate(bookingDto.getCheckOutDate());
            bookingDto.setGuestId(bookingDto.getGuestId());
            return bookingDto;
        }

        public static Booking toEntity(BookingDto bookingDto){
            Booking booking = new Booking();
            booking.setCheckOutDate(booking.getCheckOutDate());
            booking.setCheckInDate(booking.getCheckInDate());
            booking.setGuestId(booking.getGuestId());
            booking.setId(booking.getId());
            return booking;
        }

        public static Booking updateEntity(BookingDto source, Booking target) {
            target.setCheckInDate(source.getCheckInDate());
            target.setCheckOutDate(source.getCheckOutDate());
            return target;
        }

}
