package Google;

public class Company {
    private String companyName;
    private String departmnent;
    private String salary;


    public Company (String name, String departmnent, String salary) {
        this.companyName = name;
        this.departmnent = departmnent;
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDepartmnent() {
        return departmnent;
    }

    public String getSalary() {
        return salary;
    }
}
