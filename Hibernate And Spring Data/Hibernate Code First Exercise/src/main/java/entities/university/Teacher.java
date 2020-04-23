package entities.university;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "teachers")
public class Teacher extends PersonUni {

    private String email;
    private BigDecimal salaryPerHour;





    public Teacher() {
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name = "salary_per_hour")
    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }


}
