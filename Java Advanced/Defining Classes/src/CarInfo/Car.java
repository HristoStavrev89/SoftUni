package CarInfo;


public class  Car {
    private String make;
    private String model;
    private int horsePower;
   // private List<String> parts;

//    public Car () {
//        this.make = "Audi";
//    }

    public Car (String name) {
        this.make = name;
        this.model = "unknown";
        this.horsePower = -1;
       // this.parts= new ArrayList<>();

    }

    public Car (String name, String model, int horsePower) {
        this.make = name;
        this.model = model;
        this.horsePower = horsePower;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void increaseHP(int value) {
        this.horsePower += value;
    }

    public String carInfo () {
        return String.format("The car is: %s %s - %d HP.",
                this.getMake(),
                this.getModel(),
                this.getHorsePower());
    }
}
