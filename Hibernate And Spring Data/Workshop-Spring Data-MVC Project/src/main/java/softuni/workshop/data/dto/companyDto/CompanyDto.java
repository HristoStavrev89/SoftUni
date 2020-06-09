package softuni.workshop.data.dto.companyDto;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyDto {

    @XmlAttribute
    private String name;

    public CompanyDto() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
