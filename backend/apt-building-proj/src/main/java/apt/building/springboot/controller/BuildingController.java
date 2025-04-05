package apt.building.springboot.controller;

import apt.building.springboot.model.Building;
import apt.building.springboot.model.Room;
import apt.building.springboot.service.BuildingService;
import apt.building.springboot.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    BuildingService buildingService;

    @Autowired
    RoomService roomService;

    @PostMapping("/create")
    public Building createBuilding(){
        return buildingService.createBuilding();
    }

    @GetMapping("/")
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }


    @GetMapping("/{id}/rooms")
    public List<Room> getAllRooms(
            @PathVariable(name = "id") Long id
    ) {
        return roomService.getAllBuildingRoom(id);
    }

    @PutMapping("/{id}/temperature")
    public Building updateBuildingTemperature(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "requestedTemperature") float requestedTemperature
    ) {
        return buildingService.updateBuildingRequestedTemperature(id, requestedTemperature);
    }
}
