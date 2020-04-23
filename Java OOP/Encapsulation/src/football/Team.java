package football;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }


    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }


    public void addPlayer(Player player) {

        if (!this.players.contains(player)) {
            this.players.add(player);
        }


    }

    public void removePlayer(String name) {
        boolean exist = true;

        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i).getName().equals(name)) {
                this.players.remove(i);
                exist = false;
            }
        }
        if (exist) {
            System.out.println(String.format("Player %s is not in %s team."
            ,name, this.getName()));
        }
    }

    public double getRating() {
        double rating = this.players.stream()
                .mapToDouble(Player::overallSkillLevel).sum();

       return rating / this.players.size();

    }

}
