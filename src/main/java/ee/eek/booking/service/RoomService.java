package ee.eek.booking.service;

import ee.eek.booking.dto.CreateRoomRequest;
import ee.eek.booking.dto.RoomDto;
import ee.eek.booking.dto.UserDto;
import ee.eek.booking.mapper.RoomMapper;
import ee.eek.booking.mapper.UserMapper;
import ee.eek.booking.model.Room;
import ee.eek.booking.model.User;
import ee.eek.booking.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomDto addRoom(CreateRoomRequest createRoomRequest){
        Room room = RoomMapper.toEntity(createRoomRequest);
        return RoomMapper.toDto(roomRepository.save(room));

    }

    public List<RoomDto> getAll(){
        return roomRepository.findAll()
                .stream()
                .map(RoomMapper::toDto)
                .toList();
    }
    public boolean findById(Long id){
        Room room = requireRoom(id);
        return true;
    }
    private Room requireRoom(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("room not found"));
    }

}
