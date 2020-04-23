package softuni.xmlcarsdealer.domain.dto.seedDtos.partSeedDtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsRootSeedDto {

    @XmlElement(name = "part")
    private List<PartSeedDto> parts;


    public PartsRootSeedDto() {
    }


    public List<PartSeedDto> getParts() {
        return parts;
    }

    public void setParts(List<PartSeedDto> parts) {
        this.parts = parts;
    }
}
