package VehicleCatalogue;

public class VehicleCatalogue {
    private String type;
    private String model;
    private String color;
    private Integer power;

    public VehicleCatalogue(String type, String model, String color, Integer power) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.power = power;
    }


    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Integer getPower() {
        return power;
    }

    @Override
    public String toString() {
        return String.format("Type: %s\n" +
                "Model: %s\n" +
                "Color: %s\n" +
                "Horsepower: %d",
                this.getType().toUpperCase().charAt(0) +
                this.getType().substring(1),

                this.getModel(),
                this.getColor(),
                this.getPower());

    }
}
