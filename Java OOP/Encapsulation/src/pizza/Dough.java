package pizza;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;


    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!(flourType.equals("White") || flourType.equals("Wholegrain"))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!(bakingTechnique.equals("Crispy")
                || bakingTechnique.equals("Chewy")
                || bakingTechnique.equals("Homemade"))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private double getWeight() {
        return this.weight;
    }

    private String getFlourType() {
        return this.flourType;
    }

    private String getBakingTechnique() {
        return this.bakingTechnique;
    }

    public double calculateCalories() {
        double calories = this.getWeight() * 2;

        if (this.getFlourType().equals("White")) {
            calories *= 1.5;
        } else if (this.getFlourType().equals("Wholegrain")) {
            calories *= 1.0;
        }

        if (this.getBakingTechnique().equals("Crispy")) {
            calories *= 0.9;
        } else if (this.getBakingTechnique().equals("Chewy")) {
            calories *= 1.1;
        } else if (this.getBakingTechnique().equals("Homemade")) {
            calories *= 1.0;
        }
        return calories;
    }


}
