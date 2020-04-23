package softuni.exam.domain.jsonViewDtos.northHubPlayers;

import com.google.gson.annotations.Expose;

public class PlayerViewDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String position;
    @Expose
    private int number;

    public PlayerViewDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
