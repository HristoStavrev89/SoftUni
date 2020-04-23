package softuni.xmlcarsdealer.domain.dto.xmlDtos.carPartXmlDtos;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarPartRootViewDto {

    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;
    @XmlElement
    private PartRootViewDto partRootViewDto;

    public CarPartRootViewDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public PartRootViewDto getPartRootViewDto() {
        return partRootViewDto;
    }

    public void setPartRootViewDto(PartRootViewDto partRootViewDto) {
        this.partRootViewDto = partRootViewDto;
    }
}
