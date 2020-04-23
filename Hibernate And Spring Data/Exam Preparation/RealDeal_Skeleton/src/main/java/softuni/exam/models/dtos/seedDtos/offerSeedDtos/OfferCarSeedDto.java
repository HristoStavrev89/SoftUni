package softuni.exam.models.dtos.seedDtos.offerSeedDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferCarSeedDto {

    @XmlElement(name = "id")
    private int id;

    public OfferCarSeedDto() {


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
