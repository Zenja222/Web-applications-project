package ee.eek.booking.web;

import ee.eek.booking.dto.CreateRoomRequest;
import ee.eek.booking.dto.RoomDto;
import ee.eek.booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("rooms")
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public RoomDto addRoom(@RequestBody CreateRoomRequest request){
        return roomService.addRoom(request);
    }

    @GetMapping
    public List<RoomDto> getAll(){
        return roomService.getAll();
    }

    @GetMapping("/available")
    public List<RoomDto> findAvailableRooms(){
        return roomService.findAvailableRooms();
    }
}

