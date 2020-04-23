package com.softuni.entity;

public class Calaculator {
    private double leftOperand;
    private double rightOperand;
    private String operator;

    public Calaculator(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public double getLeftOperand() {
        return leftOperand;
    }

    public String getOperator() {
        return operator;
    }

    public double getRightOperand() {
        return rightOperand;
    }

    public double calculateResult() {
        double result = 0.0;

        if ("+".equals(this.operator)) {
            result = this.leftOperand + this.rightOperand;
        } else if ("-".equals(this.operator)) {
            result = this.leftOperand - this.rightOperand;
        } else if ("*".equals(this.operator)) {
            result = this.leftOperand * this.rightOperand;
        } else if ("/".equals(this.operator)) {
            result = this.leftOperand / this.rightOperand;
        } else if ("^".equals(this.operator)) {
            result = 1.0;
            for (int i = 1; i <= this.rightOperand; i++) {
                result *= this.leftOperand;
            }
        }
        return result;
    }
}
