package hero;

public class Hero {
    private String userName;
    private int level;

    public Hero(String name, int level) {
        this.userName = name;
        this.level = level;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %ds"
        ,this.getClass().getName()
        ,this.getUserName()
        ,this.getLevel());
    }
}
