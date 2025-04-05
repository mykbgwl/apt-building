package apt.building.springboot.controller;

import apt.building.springboot.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add/{buildingId}")
    public ResponseEntity<?> addRoom(
            @PathVariable Long buildingId
    ) {
        roomService.addRoom(buildingId);
        return ResponseEntity.ok("Room created for building with ID: " + buildingId);
    }
}
