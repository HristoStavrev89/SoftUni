package systemSplit.core.model.hardware;

import systemSplit.core.model.software.Software;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public abstract class Hardware {
    private String name;
    private Type type;
    private int capacityMax;
    private int memoryMax;
    private List<Software> softwares;
    private int usedCapacity;
    private int usedMemory;

    protected Hardware(String name, Type type, int capacityMax, int memoryMax) {
        this.name = name;
        this.type = type;
        this.capacityMax = capacityMax;
        this.memoryMax = memoryMax;
        this.softwares = new ArrayList<>();
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    public String getName() {
        return this.name;
    }


    public int getSoftwareCount() {
        return this.softwares.size();
    }


    public int getCapacityMax() {
        return this.capacityMax;
    }

    public int getMemoryMax() {
        return this.memoryMax;
    }


    public void addSoftware(Software software) {
        if (software.getMemoryConsumption() <= this.getMemoryMax() &&
                software.getCapacityConsumption() <= this.getCapacityMax()) {
            this.softwares.add(software);
            this.setUsedResources(software, (a, b) -> a += b);

        }
    }

    public final int getUsedCapacity() {
        return this.usedCapacity;
    }

    public final int getUsedMemory() {
        return this.usedMemory;
    }

    private void setUsedResources(Software software, BinaryOperator<Integer> operator) {
        this.usedCapacity = operator.apply(this.usedCapacity, software.getCapacityConsumption());
        this.usedMemory = operator.apply(this.usedMemory, software.getMemoryConsumption());
    }

    public void removeSoftware(String softwareName) {
        Software software = this.softwares
                .stream()
                .filter(s -> s.getName().equalsIgnoreCase(softwareName))
                .findFirst()
                .orElse(null);

        if (software != null) {
            this.softwares.remove(software);
            this.setUsedResources(software, (a, b) -> a -= b);
        }
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        long expressSoftwareCount = this.softwares.stream().filter(s -> s.getClass().getSimpleName()
        .equals("ExpressSoftware"))
                .count();
        String.format("Hardware Component – %s%n" +
                "Express Software Components - %d%n" +
                "Light Software Components - %d%n" +
                "Memory Usage: %d / %d%n" +
                "Capacity Usage: %d / %d%n" +
                "Type: %s%n" +
                "Software Components: %s%n",
                this.getName(),
                expressSoftwareCount,
                this.softwares.size() - expressSoftwareCount,
                this.usedMemory,
                this.getMemoryMax() + this.usedMemory,
                this.usedCapacity,
                this.getUsedCapacity() + this.usedCapacity,
                this.type.compareTo(Type.HRAVY) == 0 ? "Heavy" : "Power",
                this.softwares.size() == 0 ? "None":
                        this.softwares.stream().map(Software::getName)
                                .collect(Collectors.joining(", ")))
                ;
        //todo da doopravq problema s getarite v metoda


        return super.toString();
    }
}
