package softuni.workshop.web.models;

import java.math.BigDecimal;

public class ProjectViewModel {
    private String name;
    private String description;
    private BigDecimal payment;

    public ProjectViewModel() {
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

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return String.format("Project Name: %s\n\tDescription: %s\n\t%.2f",
        this.getName(), this.getDescription(), this.getPayment()
        );
    }
}
