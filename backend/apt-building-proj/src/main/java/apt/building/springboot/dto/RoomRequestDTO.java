package apt.building.springboot.dto;

import apt.building.springboot.model.type.CommonRoomType;
import apt.building.springboot.model.type.RoomType;
import lombok.Data;

@Data
public class RoomRequestDTO {

    private RoomType roomType ;
    private String ownerName;
    private int apartmentNumber;
    private CommonRoomType commonRoomType;
}
