package apt.building.springboot.service;

import apt.building.springboot.model.Building;
import apt.building.springboot.model.Room;
import apt.building.springboot.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    private final BuildingService buildingService;

    public RoomService(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    public List<Room> getAllBuildingRoom(long buildingId) {
        return roomRepository.findByBuilding_Id(buildingId);
    }

    @Transactional
    public void addRoom(Long buildingId) {
        Building building = buildingService.getBuildingById(buildingId);
        Room room = new Room();
        room.setBuilding(building);
        building.getRooms().add(room);
    }

    @Transactional
    public void addApt(Long buildingId) {
        Building building = buildingService.getBuildingById(buildingId);
        Room room = new Room();
        room.setBuilding(building);
        building.getRooms().add(room);
    }

    @Transactional
    public void addRomCom(Long buildingId) {
        Building building = buildingService.getBuildingById(buildingId);
        Room room = new Room();
        room.setBuilding(building);
        building.getRooms().add(room);
    }
}
