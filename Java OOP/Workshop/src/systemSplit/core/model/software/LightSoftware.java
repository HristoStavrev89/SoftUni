package systemSplit.core.model.software;

public class LightSoftware extends Software {
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, Type.LIGHT, capacityConsumption, memoryConsumption);
    }


    @Override
    public int getCapacityConsumption() {
        int basecapacityConsumption = super.getCapacityConsumption();
        basecapacityConsumption += basecapacityConsumption / 2;
        return basecapacityConsumption;
    }

    @Override
    public int getMemoryConsumption() {
        int memoryConsumption = super.getMemoryConsumption();
        memoryConsumption -= memoryConsumption / 2;
        return memoryConsumption;
    }
}
