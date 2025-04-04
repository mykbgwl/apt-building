package apt.building.springboot.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BuildingDTO
{

    //@Serial
    //private static final long serialVersionUID= 7977590605556029475L;
    private Long id;
    private double defaultTemp;
    private List<RoomDTO> rooms = new ArrayList<>();
}
