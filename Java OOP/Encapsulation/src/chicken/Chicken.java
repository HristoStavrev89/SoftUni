package chicken;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName() {
        return this.name;
    }

    private int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty() || name.equals("null")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private double calculateProductPerDay(int age){
        double eggs;
        if (this.age < 6) {
            eggs = 2;
        } else if (this.age < 12){
            eggs = 1;
        } else {
            eggs = 0.75;
        }
        return eggs;
    }



    public double productPerDay () {
        return calculateProductPerDay(this.getAge());
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day."
        ,this.getName()
        ,this.getAge()
        ,this.productPerDay());
    }
}
