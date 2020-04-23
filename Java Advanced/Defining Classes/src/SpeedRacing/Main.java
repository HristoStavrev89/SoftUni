package SpeedRacing;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Cars> stats = new LinkedHashMap<>();
        Map<String, Integer> totalKm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fouelCost1Km = Double.parseDouble(data[2]);

            Cars cars = new Cars(fuelAmount, fouelCost1Km);

            stats.putIfAbsent(model, cars);

        }

        String input = "";

        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            if (data[0].equals("Drive")) {

                String drivenModel = data[1];
                int drivenKm = Integer.parseInt(data[2]);

                if (!totalKm.containsKey(drivenModel)) {
                    totalKm.put(drivenModel, drivenKm);
                } else {
                    totalKm.put(drivenModel, totalKm.get(drivenModel) + drivenKm);
                }

                double costs = drivenKm * stats.get(drivenModel).getFuelCostPerKm();

                double fuelMinusCosts = stats.get(drivenModel).getFuelAmount() - costs;

                if (costs < stats.get(drivenModel).getFuelAmount()) {
                    stats.get(drivenModel).setFuelAmount(fuelMinusCosts);
                    int kmTravel = stats.get(drivenModel).getTotaKm();
                    stats.get(drivenModel).setTotaKm(kmTravel + drivenKm);

                } else {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
        }
        stats.entrySet()
                .stream()
                .forEach(car -> {
                    System.out.println(String.format("%s %.2f %d",
                            car.getKey(),
                            car.getValue().getFuelAmount(),
                            car.getValue().getTotaKm()));

                });



    }
}
