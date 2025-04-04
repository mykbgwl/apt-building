package apt.building.springboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double defaultTemp=20.0;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();
}
