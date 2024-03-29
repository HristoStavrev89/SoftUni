package animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;


    public Animal(String name, int age, String gender) {
        this.name = name;
        this.setAge(age);
        this.gender = gender;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw  new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public abstract String produceSound();


    @Override
    public String toString() {
        return String.format("%s\n%s %d %s\n%s"
        ,this.getClass().getSimpleName()
        ,this.getName()
        ,this.getAge()
        ,this.getGender()
        ,produceSound());
    }
}
