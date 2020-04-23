package softuni.carsdealer.domain.dtos.viewDtos.carsWithTheirParts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarPartDtoView {

    @Expose
    private CarDtoModelView car;
    @Expose
    private List<PartDtoView> parts;

    public CarPartDtoView() {
    }

    public CarDtoModelView getCar() {
        return car;
    }

    public void setCar(CarDtoModelView car) {
        this.car = car;
    }

    public List<PartDtoView> getParts() {
        return parts;
    }

    public void setParts(List<PartDtoView> parts) {
        this.parts = parts;
    }
}
