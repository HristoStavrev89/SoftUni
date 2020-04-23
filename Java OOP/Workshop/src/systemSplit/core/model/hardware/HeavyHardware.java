package systemSplit.core.model.hardware;
public class HeavyHardware extends Hardware {




    public HeavyHardware(String name, int capacityMax, int memoryMax) {
        super(name, Type.HRAVY, capacityMax, memoryMax);
    }


    @Override
    public int getCapacityMax() {
        int baseCapacity = super.getCapacityMax();
        baseCapacity *= 2;
        return baseCapacity - super.getUsedCapacity();
    }

    @Override
    public int getMemoryMax() {
        int baseMemory = super.getMemoryMax();
        baseMemory -= baseMemory / 4;
        return baseMemory - super.getUsedMemory();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
