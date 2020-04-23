package repositories;

import common.ConstantMessages;
import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayerRepositoryImpl implements PlayerRepository {
    private Map<String, Player> playerRepository;


    public PlayerRepositoryImpl() {
        this.playerRepository = new LinkedHashMap<>();
    }


    @Override
    public int getCount() {
        return this.playerRepository.values().size();
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.playerRepository.values()
                .stream().collect(Collectors.toList()));
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new IllegalArgumentException(ConstantMessages.PLAYER_CANNOT_BE_NULL);
        }

        if (this.playerRepository.containsKey(player.getUsername())) {
            throw new IllegalArgumentException(String.format("Player %s already exists!", player.getUsername()));
        }

        this.playerRepository.put(player.getUsername(), player);

    }

    @Override
    public boolean remove(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        Player removedPlayer = this.playerRepository.remove(player.getUsername());
        boolean isRemoved = true;


        if (removedPlayer == null) {
            isRemoved = false;
        }

        return isRemoved;
    }

    @Override
    public Player find(String name) {
        Player player = this.playerRepository.get(name);
        return player;
    }
}
