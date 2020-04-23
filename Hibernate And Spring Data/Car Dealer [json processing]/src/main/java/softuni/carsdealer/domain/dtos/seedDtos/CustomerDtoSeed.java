package softuni.carsdealer.domain.dtos.seedDtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class CustomerDtoSeed {

    @Expose
    private String name;
    @Expose
    private LocalDateTime birthDate;
    @Expose
    private boolean isYoungDriver;

    public CustomerDtoSeed() {
    }

    @Length(min = 2, message = "Customer name must be longer.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
