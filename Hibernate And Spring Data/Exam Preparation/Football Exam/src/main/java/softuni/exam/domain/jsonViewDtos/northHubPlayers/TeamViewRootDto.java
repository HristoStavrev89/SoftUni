package softuni.exam.domain.jsonViewDtos.northHubPlayers;

import com.google.gson.annotations.Expose;

import java.util.List;

public class TeamViewRootDto {

    @Expose
    private String name;
    @Expose
    private List<PlayerViewDto> players;

    public TeamViewRootDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlayerViewDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerViewDto> players) {
        this.players = players;
    }
}
