package OpinionPoll;

public class Person {
    private String name;
    private Integer ages;



    public Person(String name, Integer ages) {
        this.name = name;
        this.ages = ages;
    }



    public String getName() {
        return this.name;
    }

    public Integer getAges() {
        return this.ages;
    }

    @Override
    public String toString() {
        return String.format("%s - %d",
                this.getName(),
                this.getAges());
    }
}
