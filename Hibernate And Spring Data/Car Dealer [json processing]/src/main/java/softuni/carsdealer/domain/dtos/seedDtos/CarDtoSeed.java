package softuni.carsdealer.domain.dtos.seedDtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class CarDtoSeed {

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private long travelledDistance;

    public CarDtoSeed() {
    }



    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @NotNull
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @DecimalMin(value = "0", message = "Travelled kilometers are only positive number.")
    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
