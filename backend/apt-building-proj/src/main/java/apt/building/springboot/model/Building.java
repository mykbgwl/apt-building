package apt.building.springboot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float requestedTemperature = 20.0f;

    @JsonManagedReference
    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();


    public Building() {
    }

    public Building(float requestedTemperature, Long id, List<Room> rooms) {
        this.requestedTemperature = requestedTemperature;
        this.id = id;
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public float getRequestedTemperature() {
        return requestedTemperature;
    }

    public void setRequestedTemperature(float requestedTemperature) {
        this.requestedTemperature = requestedTemperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
