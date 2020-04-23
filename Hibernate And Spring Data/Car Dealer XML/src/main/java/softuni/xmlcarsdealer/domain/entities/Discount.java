package softuni.xmlcarsdealer.domain.entities;

public enum Discount {
    ZERO(0),
    FIVE(5),
    TEN(10),
    FIFTEEN(15),
    TWENTY(20),
    THIRTY(30),
    FORTY(40),
    FIFTY(50);


    private int valueNum;

    Discount(int valueNum) {
        this.valueNum = valueNum;
    }

    public int getValueNum() {
        return valueNum;
    }


}
