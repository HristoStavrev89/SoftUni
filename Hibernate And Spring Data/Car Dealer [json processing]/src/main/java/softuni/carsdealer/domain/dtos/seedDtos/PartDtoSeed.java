package softuni.carsdealer.domain.dtos.seedDtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PartDtoSeed {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private int quantity;

    public PartDtoSeed() {
    }


    @NotNull
    @Length(min = 3, message = "The name of the part is too short.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @DecimalMin(value = "0.40", message = "The price for the part is too low.")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
