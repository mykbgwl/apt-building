package apt.building.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "room_id")
public class CommonRoom extends Room {
    private String type;

    public CommonRoom(Building building,String type) {
        super(building);
        this.type = type;
    }

    public CommonRoom() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
