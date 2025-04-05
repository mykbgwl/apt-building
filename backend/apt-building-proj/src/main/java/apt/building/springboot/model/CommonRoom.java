package apt.building.springboot.model;

import apt.building.springboot.model.type.CommonRoomType;
import apt.building.springboot.model.type.RoomType;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "room_id")
public class CommonRoom extends Room {

    private CommonRoomType commonRoomType;

    public CommonRoom() {
    }

    public CommonRoom(Building building, RoomType roomType, CommonRoomType commonRoomType) {
        super(building, roomType);
        this.commonRoomType = commonRoomType;
    }

    public CommonRoomType getCommonRoomType() {
        return commonRoomType;
    }

    public void setCommonRoomType(CommonRoomType commonRoomType) {
        this.commonRoomType = commonRoomType;
    }
}
