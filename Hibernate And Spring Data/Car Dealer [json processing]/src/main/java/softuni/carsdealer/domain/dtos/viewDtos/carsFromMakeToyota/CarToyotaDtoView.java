package softuni.carsdealer.domain.dtos.viewDtos.carsFromMakeToyota;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarToyotaDtoView {

    @Expose
    @SerializedName(value = "Id")
    private long id;
    @Expose
    @SerializedName(value = "Make")
    private String make;
    @Expose
    @SerializedName(value = "Model")
    private String model;
    @Expose
    @SerializedName(value = "TravelledDistance")
    private Long travelledDistance;

    public CarToyotaDtoView() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
