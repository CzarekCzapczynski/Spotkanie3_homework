package com.company.runner;

public class Nutrient {
    protected double mass, caloricFactor;

    Nutrient() {
        this.mass = 0;
        this.caloricFactor = 0;
    }

    Nutrient(double mass, double caloricFactor) {
        this.mass = mass;
        this.caloricFactor = caloricFactor;
    }

    public void setCaloricFactor(double caloricFactor) {
        this.caloricFactor = caloricFactor;
    }

    public double getCaloricFactor() {
        return caloricFactor;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double nutrientEnergyValue() {
        return (this.mass * this.caloricFactor);
    }

    public void printNutrientEnergyValue() {
        System.out.printf("energy value: %.2f", nutrientEnergyValue());
        System.out.println(" kcal");
    }
}
