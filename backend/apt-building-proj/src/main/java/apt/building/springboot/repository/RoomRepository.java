package apt.building.springboot.repository;

import apt.building.springboot.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByBuilding_Id(long buildingId);
}
