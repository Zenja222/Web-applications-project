package ee.eek.booking.mapper;

import ee.eek.booking.dto.BookingDto;
import ee.eek.booking.dto.CreateRoomRequest;
import ee.eek.booking.dto.RoomDto;
import ee.eek.booking.model.Booking;
import ee.eek.booking.model.Room;

public class RoomMapper {

    public static RoomDto toDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setRoomType(room.getRoomType());
        roomDto.setPrice(room.getPrice());
        roomDto.setStatus(room.isStatus());
        return roomDto;
    }

    public static Room toEntity(CreateRoomRequest request){
        Room room = new Room();
        room.setRoomType(request.getRoomType());
        room.setPrice(request.getPrice());
        room.setStatus(request.isStatus());
        return room;
    }

    public static Room updateEntity(RoomDto source, Room target) {
        target.setStatus(source.isStatus());
        return target;
    }
}
