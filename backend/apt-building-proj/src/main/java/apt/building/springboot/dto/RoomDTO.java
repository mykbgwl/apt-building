package apt.building.springboot.dto;

import lombok.Data;

@Data
public class RoomDTO {
    private Long id;
    private double temp;
    private boolean heatingEnabled;
    private boolean coolingEnabled;

}
