package CardsWithPower;

public class Card {

    private RankPowers rankPowers;
    private SuitPowers suitPowers;


    public Card(RankPowers rankPowers, SuitPowers suitPowers) {
        this.rankPowers = rankPowers;
        this.suitPowers = suitPowers;
    }


    public int calculatePower() {
        return this.rankPowers.getPower() + this.suitPowers.getSuitPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d"
        ,this.rankPowers
                ,this.suitPowers
                ,this.calculatePower());
    }
}
