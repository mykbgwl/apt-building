package apt.building.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "room_id")
public class CommonRoom extends Room {
    private String type;
}
