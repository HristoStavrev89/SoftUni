package softuni.exam.domain.jsonSeedDtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;
import softuni.exam.domain.entity.Position;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PlayerRootSeedDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int number;
    @Expose
    private BigDecimal salary;
    @Expose
    private String position;
    @Expose
    private PlayerPictureSeedDto picture;
    @Expose
    private PlayerTeemSeedDto team;

    public PlayerRootSeedDto() {
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Length(min = 3, max = 15)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @Min(1)
    @Max(99)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @NotNull
    @Min(0)
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @NotNull
    @Length(max = 3)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @NotNull
    public PlayerPictureSeedDto getPicture() {
        return picture;
    }

    public void setPicture(PlayerPictureSeedDto picture) {
        this.picture = picture;
    }

    @NotNull
    public PlayerTeemSeedDto getTeam() {
        return team;
    }

    public void setTeam(PlayerTeemSeedDto team) {
        this.team = team;
    }
}
