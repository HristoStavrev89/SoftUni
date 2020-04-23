package softuni.exam.models.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    private String serialNumber;
    private BigDecimal price;
    private LocalDateTime takeOff;

    private Town fromTownId;
    private Passenger passenger;
    private Plane plane;
    private Town toTown;

    public Ticket() {
    }


    @Column(unique = true)
    @Length(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @DecimalMin(value = "0.01")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "take_off")
    public LocalDateTime getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(LocalDateTime takeOff) {
        this.takeOff = takeOff;
    }


    @ManyToOne
    @JoinColumn(name = "from_town_id", referencedColumnName = "id")
    public Town getFromTownId() {
        return fromTownId;
    }


    public void setFromTownId(Town fromTownId) {
        this.fromTownId = fromTownId;
    }

    @ManyToOne
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @ManyToOne
    @JoinColumn(name = "plane_id", referencedColumnName = "id")
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @ManyToOne
    @JoinColumn(name = "to_town_id", referencedColumnName = "id")
    public Town getToTown() {
        return toTown;
    }

    public void setToTown(Town toTown) {
        this.toTown = toTown;
    }
}
