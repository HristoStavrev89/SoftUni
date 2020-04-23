package softuni.exam.domain.jsonSeedDtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;


public class PlayerPictureSeedDto {

    @Expose
    private String url;

    public PlayerPictureSeedDto() {
    }

    @NotNull
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
