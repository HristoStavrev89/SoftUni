package systemSplit.core.model.hardware;
public class PowerHardware extends Hardware {



    //todo extract magic nums to const
    public PowerHardware(String name, int capacityMax, int memoryMax) {
        super(name, Type.POWER, capacityMax, memoryMax);
    }


    @Override
    public int getCapacityMax() {
        int baseCapacity = super.getCapacityMax();
        baseCapacity -= ((baseCapacity * 3) / 4);
        return baseCapacity - super.getUsedCapacity();
    }

    @Override
    public int getMemoryMax() {
        int baseMemory = super.getMemoryMax();
        baseMemory += ((baseMemory * 3) / 4);
        return baseMemory - super.getUsedMemory();
    }

}
