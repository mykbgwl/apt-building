package apt.building.springboot.model;

import apt.building.springboot.model.type.RoomType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float temp = (float) (10 + Math.random() * 30);
    private boolean heatingEnabled;
    private boolean coolingEnabled;

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    private RoomType roomType = RoomType.ROOM;
    @ManyToOne
    @JoinColumn(name = "building_id")
    @JsonBackReference
    private Building building;

    public Room() {
    }

    public Room(Building building, RoomType roomType) {
        this.building = building;
        this.roomType = roomType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public boolean isHeatingEnabled() {
        return temp < building.getRequestedTemperature();
    }

    public void setHeatingEnabled(boolean heatingEnabled) {
        this.heatingEnabled = heatingEnabled;
    }

    public boolean isCoolingEnabled() {
        return temp > building.getRequestedTemperature();
    }

    public void setCoolingEnabled(boolean coolingEnabled) {
        this.coolingEnabled = coolingEnabled;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
