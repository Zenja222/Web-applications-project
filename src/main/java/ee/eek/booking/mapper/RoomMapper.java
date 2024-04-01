package ee.eek.booking.mapper;

import ee.eek.booking.dto.RoomDto;
import ee.eek.booking.model.Room;

public class RoomMapper {

    public static RoomDto toDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setRoomType(room.getRoomType());
        roomDto.setPrice(room.getPrice());
        return roomDto;
    }

    public static Room toEntity(RoomDto roomDto){
        Room room = new Room();
        room.setRoomType(room.getRoomType());
        room.setPrice(room.getPrice());
        room.setId(room.getId()); // ? ???
        return room;
    }
}
