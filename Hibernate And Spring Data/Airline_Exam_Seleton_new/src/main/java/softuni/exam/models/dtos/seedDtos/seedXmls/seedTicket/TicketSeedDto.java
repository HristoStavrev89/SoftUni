package softuni.exam.models.dtos.seedDtos.seedXmls.seedTicket;



import org.hibernate.validator.constraints.Length;
import softuni.exam.adaptors.LocalDateTimeAdaptor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketSeedDto {

    @XmlElement(name = "serial-number")
    private String serialNumber;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "take-off")
    @XmlJavaTypeAdapter(LocalDateTimeAdaptor.class)
    private LocalDateTime takeOff;

    @XmlElement(name = "from-town")
    private TicketTownDto fromTown;

    @XmlElement(name = "to-town")
    private TicketTownDto toTown;

    @XmlElement(name = "passenger")
    private TicketPassengerDto passenger;

    @XmlElement(name = "plane")
    private TicketPlaneDto plane;

    public TicketSeedDto() {
    }

    @NotNull
    @Length(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @NotNull
    @DecimalMin(value = "0.1")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    public LocalDateTime getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(LocalDateTime takeOff) {
        this.takeOff = takeOff;
    }

    @NotNull
    public TicketTownDto getFromTown() {
        return fromTown;
    }

    public void setFromTown(TicketTownDto fromTown) {
        this.fromTown = fromTown;
    }

    @NotNull
    public TicketTownDto getToTown() {
        return toTown;
    }

    public void setToTown(TicketTownDto toTown) {
        this.toTown = toTown;
    }

    @NotNull
    public TicketPassengerDto getPassenger() {
        return passenger;
    }

    public void setPassenger(TicketPassengerDto passenger) {
        this.passenger = passenger;
    }

    @NotNull
    public TicketPlaneDto getPlane() {
        return plane;
    }

    public void setPlane(TicketPlaneDto plane) {
        this.plane = plane;
    }
}
