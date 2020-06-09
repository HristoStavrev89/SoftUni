package softuni.workshop.data.dto.projectDto;
import softuni.workshop.data.dto.companyDto.CompanyDto;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectDto {

    @XmlElement
    private String name;
    @XmlElement
    private String description;
    @XmlElement(name = "start-date")
    private String startDate;
    @XmlElement(name = "is-finished")
    private boolean isFinished;
    @XmlElement
    private BigDecimal payment;
    @XmlElement(name = "company")
    private CompanyDto company;


    public ProjectDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }
}
