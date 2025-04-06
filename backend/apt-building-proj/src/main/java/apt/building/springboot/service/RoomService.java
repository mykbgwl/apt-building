package apt.building.springboot.service;

import apt.building.springboot.dto.RoomRequestDTO;
import apt.building.springboot.model.Apartment;
import apt.building.springboot.model.Building;
import apt.building.springboot.model.CommonRoom;
import apt.building.springboot.model.Room;
import apt.building.springboot.model.type.RoomType;
import apt.building.springboot.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public Room addRoom(Long buildingId, RoomRequestDTO requestDTO) {
        Building building = buildingService.getBuildingById(buildingId);
        RoomType roomType = requestDTO.getRoomType();
        Room room;
        switch (roomType) {
            case APARTMENT: {
                room = new Apartment(building, RoomType.APARTMENT, requestDTO.getApartmentNumber(), requestDTO.getOwnerName());
                building.getRooms().add(room);
                break;
            }
            case COMMON_ROOM: {
                room = new CommonRoom(building, RoomType.COMMON_ROOM, requestDTO.getCommonRoomType());
                building.getRooms().add(room);
                break;
            }
            case ROOM: {
                room = new Room();
                room.setBuilding(building);
                building.getRooms().add(room);
                break;
            }
            default: {
                throw new IllegalArgumentException("Incompatible room type:" + roomType);
            }
        }
        return room;
    }

    @Transactional
    public Room updateRoom(Long roomId, Long buildingId, RoomRequestDTO requestDTO) {
        Building building = buildingService.getBuildingById(buildingId);

        Room roomToBeUpdated = building.getRooms().stream()
                .filter(room -> Objects.equals(room.getId(), roomId)).findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Room not found with RoomId:  " + roomId + " and BuildingId: " + buildingId));

        if (roomToBeUpdated instanceof Apartment apartment) {
            apartment.setApartmentNumber(requestDTO.getApartmentNumber());
            apartment.setOwnerName(requestDTO.getOwnerName());
        } else if (roomToBeUpdated instanceof CommonRoom commonRoom) {
            commonRoom.setCommonRoomType(requestDTO.getCommonRoomType());
        }
        return roomRepository.save(roomToBeUpdated);
    }

    @Transactional
    public void removeRoom(Long roomId, Long buildingId) {
        Building building = buildingService.getBuildingById(buildingId);
        Room roomToBeRemoved = building.getRooms().stream()
                .filter(room -> Objects.equals(room.getId(), roomId)).findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Room not found with RoomId:  " + roomId + " and BuildingId: " + buildingId));
        building.getRooms().remove(roomToBeRemoved);
        roomRepository.delete(roomToBeRemoved);
    }
}
