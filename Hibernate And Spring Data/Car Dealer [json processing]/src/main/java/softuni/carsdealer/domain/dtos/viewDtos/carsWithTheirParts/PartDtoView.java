package softuni.carsdealer.domain.dtos.viewDtos.carsWithTheirParts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class PartDtoView {

    @Expose
    @SerializedName(value = "Name")
    private String name;
    @Expose
    @SerializedName(value = "Price")
    private BigDecimal price;

    public PartDtoView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
