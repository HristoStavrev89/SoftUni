package softuni.xmlcarsdealer.domain.dto.xmlDtos.carPartXmlDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarPartRootViewDtoWrapp {

    @XmlElement(name = "car")
    private List<CarPartRootViewDto> cars;


    public CarPartRootViewDtoWrapp() {
    }

    public List<CarPartRootViewDto> getCars() {
        return cars;
    }

    public void setCars(List<CarPartRootViewDto> cars) {
        this.cars = cars;
    }
}
