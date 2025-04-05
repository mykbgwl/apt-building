package apt.building.springboot.controller;

import apt.building.springboot.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping("/add/apartment/{buildingId}")
    public ResponseEntity<?> addApt(
            @PathVariable Long buildingId
    ) {
        roomService.addApt(buildingId);
        return ResponseEntity.ok("Apartment created for building with ID: " + buildingId);
    }

    @PostMapping("/add/commonroom/{buildingId}")
    public ResponseEntity<?> addRomCom(
            @PathVariable Long buildingId
    ) {
        roomService.addRomCom(buildingId);
        return ResponseEntity.ok("Common Room created for building with ID: " + buildingId);
    }
}
