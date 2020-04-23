package softuni.carsdealer.domain.dtos.viewDtos.orderedCustomers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.carsdealer.domain.entities.Sale;

import java.time.LocalDateTime;
import java.util.Set;

public class CustomerDtoView {


    @Expose
    @SerializedName(value = "Id")
    private long id;
    @Expose
    @SerializedName(value = "Name")
    private String name;
    @Expose
    @SerializedName(value = "BirthDate")
    private LocalDateTime birthDate;
    @Expose
    @SerializedName(value = "IsYoungDriver")
    private boolean isYoungDriver;
    @Expose
    @SerializedName(value = "Sales")
    private Set<SaleDtoView> sales;

    public CustomerDtoView() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<SaleDtoView> getSales() {
        return sales;
    }

    public void setSales(Set<SaleDtoView> sales) {
        this.sales = sales;
    }
}
