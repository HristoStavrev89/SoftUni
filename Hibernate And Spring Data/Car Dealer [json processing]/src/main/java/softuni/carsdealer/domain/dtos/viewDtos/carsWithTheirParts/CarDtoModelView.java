package softuni.carsdealer.domain.dtos.viewDtos.carsWithTheirParts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarDtoModelView {

    @Expose
    @SerializedName(value = "Make")
    private String make;
    @Expose
    @SerializedName(value = "Model")
    private String model;
    @Expose
    @SerializedName(value = "TravelledDistance")
    private Long travelledDistance;

    public CarDtoModelView() {
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
}
