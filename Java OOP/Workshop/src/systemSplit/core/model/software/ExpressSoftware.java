package systemSplit.core.model.software;

public class ExpressSoftware extends Software {
    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, Type.EXPRESS, capacityConsumption, memoryConsumption);
    }




    @Override
    public int getMemoryConsumption() {
        int baseMemoryConsumption = super.getMemoryConsumption();
        baseMemoryConsumption *= 2;
        return baseMemoryConsumption;
    }
}
