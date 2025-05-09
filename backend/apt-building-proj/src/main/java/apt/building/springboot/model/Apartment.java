package apt.building.springboot.model;

import apt.building.springboot.model.type.RoomType;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "room_id")
public class Apartment extends Room {

    private int apartmentNumber;
    private String ownerName;

    public Apartment() {
    }

    public Apartment(Building building, RoomType roomType, int apartmentNumber, String ownerName) {
        super(building,roomType);
        this.apartmentNumber = apartmentNumber;
        this.ownerName = ownerName;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
