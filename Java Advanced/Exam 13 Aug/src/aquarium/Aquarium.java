package aquarium;

import java.util.LinkedHashMap;
import java.util.Map;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private Map<String, Fish> fishInPool;


    public Aquarium(String name, int capacity, int theVolumeOfthePool) {
        this.name = name;
        this.capacity = capacity;
        this.size = theVolumeOfthePool;
        this.fishInPool = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }

    public int getFishInPool(){
        return this.fishInPool.values().size();
    }

    public void add(Fish fish){
        if (this.getCapacity() > this.getFishInPool()){
            fishInPool.putIfAbsent(fish.getName(), fish);
        }
    }

    public boolean remove(String name){
        if (this.fishInPool.containsKey(name)) {
            this.fishInPool.remove(name);
            return true;
        } else {
            return false;
        }
    }

    public Fish findFish(String name) {
        Fish fish = null;
        if (this.fishInPool.containsKey(name)) {
            fish = this.fishInPool.get(name);
        }
        return fish;
    }

    public String report(){
        StringBuilder sb = new StringBuilder();

        String info = String.format("Aquarium: %s ^ Size: %d", this.getName(), this.getSize());
        sb.append(info).append(System.lineSeparator());

        for (Map.Entry<String, Fish> stringFishEntry : this.fishInPool.entrySet()) {
            sb.append(stringFishEntry.getValue().toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
