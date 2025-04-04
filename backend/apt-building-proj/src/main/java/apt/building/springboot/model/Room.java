package apt.building.springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temp;
    private boolean heatingEnabled;
    private boolean coolingEnabled;
    @ManyToOne
    @JoinColumn(name = "rooms")
    private Building building;
    public Room() {
        this.temp = 10 + Math.random() * 30;
    }
}
