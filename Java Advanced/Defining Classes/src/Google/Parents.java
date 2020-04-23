package Google;

public class Parents {
    private String parentName;
    private String parentBirthDay;

    public Parents (String name, String birth) {
        this.parentName = name;
        this.parentBirthDay = birth;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentBirthDay() {
        return parentBirthDay;
    }
}
