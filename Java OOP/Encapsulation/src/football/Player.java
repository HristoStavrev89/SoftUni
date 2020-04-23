package football;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);

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


    private void setEndurance(int endurance) {
        if (validateStat(endurance)) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }



    private void setSprint(int sprint) {
        if (validateStat(sprint)) {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }



    private void setDribble(int dribble) {
        if (validateStat(dribble)) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }



    private void setPassing(int passing) {
        if (validateStat(passing)) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }



    private void setShooting(int shooting) {
        if (validateStat(shooting)) {
            throw  new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
       return  (this.endurance
               + this.sprint
               + this.dribble
               + this.passing
               + this.shooting) / 5.00;
    }


    private boolean validateStat(int stat) {
        if (stat < 0 || stat > 100) {
            return true;
        }
        return false;
    }



}
