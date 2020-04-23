package softuni.carsdealer.domain.dtos.viewDtos.localSupliers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupplierDtoView {

    @Expose
    @SerializedName(value = "Id")
    private long id;
    @Expose
    @SerializedName(value = "Name")
    private String name;
    @Expose
    @SerializedName(value = "partsCount")
    private int partsCount;

    public SupplierDtoView() {
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

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }
}
