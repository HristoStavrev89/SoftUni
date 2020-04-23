package entities.footbal;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "result_prediction")
public class ResultPrediction extends BaseEntity {
    private String prediction;

    public ResultPrediction() {
    }

    @Column(name = "prediction")
    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
