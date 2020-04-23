package systemSplit.core.system;

import systemSplit.core.model.hardware.Hardware;
import systemSplit.core.model.software.Software;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SystemSplit {
    private Map<String, Hardware> hardwareComponents;


    public SystemSplit() {
        this.hardwareComponents = new LinkedHashMap<>();
    }


    public void addHardwareComponent(Hardware hardware) {
        this.hardwareComponents.put(hardware.getName(), hardware);
    }


    public void addSoftwareToHardware(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.addSoftware(software);

        }
    }

    public int getHardwareComponentSize() {
        return this.hardwareComponents.size();
    }

    public int getSoftwareComponentCount() {
       return this.hardwareComponents.values()
               .stream()
               .mapToInt(Hardware::getSoftwareCount)
                .sum();
    }


    public int getTotalOperationalMemoryInUse() {
      return this.hardwareComponents
                .values()
                .stream()
                .mapToInt(Hardware::getUsedMemory)
                .sum();
    }

    public int getTotalCapacityTaken() {
        return this.hardwareComponents
                .values()
                .stream()
                .mapToInt(Hardware::getUsedCapacity)
                .sum();
    }


    public int getMaximumMemory() {
        return this.hardwareComponents.values()
                .stream().mapToInt(Hardware::getMemoryMax)
                .sum();
    }

    public int getMaximumCapacity() {
        return this.hardwareComponents.values()
                .stream().mapToInt(Hardware::getCapacityMax)
                .sum();
    }

    public void releaseSoftware(String hardwareName, String softwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.removeSoftware(softwareName);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.hardwareComponents
                .values()
                .stream()
                .sorted((h1,h2) -> {
                    if (h1.getType().equals("Power")) {
                        return -1;
                    } else {
                        return 1;
                    }
                })
                .forEach(h ->
                        sb.append(h.toString()));
        sb.append(System.lineSeparator());

        return sb.toString().trim();
    }
}
