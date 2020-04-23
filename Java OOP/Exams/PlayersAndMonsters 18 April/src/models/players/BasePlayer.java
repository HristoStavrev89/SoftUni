package models.players;

import common.ConstantMessages;
import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {
    private static final int MIN_HEALTH_POINTS = 0;
    private static final int MIN_DAMAGE_POINTS = 0;

    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.cardRepository = cardRepository;
        this.setUsername(username);
        this.setHealth(health);
        this.setDead(false);
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < MIN_HEALTH_POINTS) {
            throw new IllegalArgumentException(ConstantMessages.MIN_HEALTH_POINTS_LESS_THAN_ZERO);
        }
        this.health = healthPoints;
    }

    private void setUsername(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ConstantMessages.PLAYER_USERNAME_NULL_OR_EMPTY);
        }
        this.username = name;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }


    private void setDead(boolean dead) {
        this.isDead = dead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < MIN_DAMAGE_POINTS) {
            throw new IllegalArgumentException(ConstantMessages.DAMAGE_POINTS_LESS_THAN_ZERO);
        }

        this.health -= damagePoints;

        if (this.health <= 0) {
            this.health = MIN_HEALTH_POINTS;
            this.isDead = true;
        }

    }

    @Override
    public String toString() {
        int cardsCount = this.cardRepository.getCount();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ConstantMessages.PLAYER_REPORT_INFO
                ,this.getUsername()
                ,this.getHealth()
                ,cardsCount))

        .append(System.lineSeparator());

        this.getCardRepository().getCards()
                .forEach(c -> sb.append(c.toString())
                        .append(System.lineSeparator()));

        sb.append(ConstantMessages.DEFAULT_REPORT_SEPARATOR);

        return sb.toString().trim();
    }
}
