package softuni.exam.domain.jsonSeedDtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class PlayerTeemSeedDto {

    @Expose
    private String name;
    @Expose
    private PlayerPictureSeedDto picture;

    public PlayerTeemSeedDto() {
    }

    @NotNull
    @Length(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public PlayerPictureSeedDto getPicture() {
        return picture;
    }

    public void setPicture(PlayerPictureSeedDto picture) {
        this.picture = picture;
    }
}
