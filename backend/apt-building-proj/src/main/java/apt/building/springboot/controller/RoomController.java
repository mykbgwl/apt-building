package apt.building.springboot.controller;

import apt.building.springboot.dto.RoomRequestDTO;
import apt.building.springboot.model.Room;
import apt.building.springboot.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add/{buildingId}")
    public ResponseEntity<Room> addRoom(
            @PathVariable(name = "buildingId") Long buildingId,
            @RequestBody RoomRequestDTO requestDTO
    ) {
        return ResponseEntity.ok(roomService.addRoom(buildingId, requestDTO));
    }

    @PutMapping("/{roomId}/update/{buildingId}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable(name = "roomId") Long roomId,
            @PathVariable(name = "buildingId") Long buildingId,
            @RequestBody RoomRequestDTO updatedRoom
    ) {
        return ResponseEntity.ok(roomService.updateRoom(roomId, buildingId, updatedRoom));
    }

    @DeleteMapping("/{roomId}/remove/{buildingId}")
    public ResponseEntity<String> deleteRoom(
            @PathVariable(name = "roomId") Long roomId,
            @PathVariable(name = "buildingId") Long buildingId
    ) {
        roomService.removeRoom(roomId, buildingId);
        return ResponseEntity.ok("Success");
    }
}
