package apt.building.springboot.service;

import apt.building.springboot.model.Apartment;
import apt.building.springboot.model.Building;
import apt.building.springboot.model.CommonRoom;
import apt.building.springboot.model.type.CommonRoomType;
import apt.building.springboot.model.type.RoomType;
import apt.building.springboot.repository.BuildingRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public Building getBuildingById(Long buildingId) {
        return buildingRepository.findById(buildingId)
                .orElseThrow(() -> new EntityNotFoundException("Building not found with ID: " + buildingId));
    }

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }


    @Transactional
    public Building createBuilding() {
        Building building = new Building();
        Apartment apartment101 = new Apartment(building, RoomType.APARTMENT, 101, "Penny Parker");
        Apartment apartment102 = new Apartment(building, RoomType.APARTMENT, 102, "Luna Snow");
        CommonRoom gym = new CommonRoom(building, RoomType.COMMON_ROOM, CommonRoomType.GYM);
        CommonRoom library = new CommonRoom(building, RoomType.COMMON_ROOM, CommonRoomType.LIBRARY);
        building.getRooms().addAll(List.of(apartment101, apartment102, gym, library));
        return buildingRepository.save(building);
    }

    @Transactional
    public Building updateBuildingRequestedTemperature(Long buildingId, float requestedTemperature) {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new EntityNotFoundException("Building not found with ID: " + buildingId));
        building.setRequestedTemperature(requestedTemperature);
        return buildingRepository.save(building);
    }
}
