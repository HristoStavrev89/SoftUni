package softuni.xmlcarsdealer.domain.dto.xmlDtos.customerXmlDtos;

import softuni.xmlcarsdealer.adaptors.LocalDateTimeAdaptor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerViewDto {

    @XmlElement
    private long id;
    @XmlElement
    private String name;
    @XmlElement(name = "birth-date")
    @XmlJavaTypeAdapter(LocalDateTimeAdaptor.class)
    private LocalDateTime birthDate;
    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;

    public CustomerViewDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
