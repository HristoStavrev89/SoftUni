package softuni.exam.models.dtos.seedDtos.pictureSeedDto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;
import softuni.exam.models.entities.Car;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PictureSeedDto {

    @Expose
    private String name;
    @Expose
    private String dateAndTime;
    @Expose
    private int car;

    public PictureSeedDto() {
    }

    @NotNull
    @Length(min = 2, max = 19)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @NotNull
    @Min(1)
    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }
}
