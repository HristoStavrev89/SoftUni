package softuni.carsdealer.domain.dtos.viewDtos.orderedCustomers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaleDtoView {

    @Expose
    @SerializedName(value = "Car")
    private CarDtoView car;
    @Expose
    @SerializedName(value = "Discount")
    private double discountPercentage;


    public SaleDtoView() {
    }

    public CarDtoView getCar() {
        return car;
    }

    public void setCar(CarDtoView car) {
        this.car = car;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
