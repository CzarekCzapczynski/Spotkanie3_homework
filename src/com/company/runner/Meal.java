package com.company.runner;

public class Meal extends Nutrient {
    protected Nutrient protein, carbohydrates, fat;
    public static double PROTEIN_ENERGY = 4; //kcal/g
    public static double CARBOHYDRATES_ENERGY = 4; //kcal/g
    public static double FAT_ENERGY = 4; //kcal/g

    Meal(double mass, double caloricFactor) {
        super(mass, caloricFactor);
    }

    Meal(int proteinMass, int carbohydratesMass, int fatMass) {
        super();
        this.protein = new Nutrient(proteinMass, PROTEIN_ENERGY);
        this.carbohydrates = new Nutrient(carbohydratesMass, CARBOHYDRATES_ENERGY);
        this.fat = new Nutrient(fatMass, FAT_ENERGY);
    }

    public double energyValue() {
        if (getMass() != 0) //jesli posilek utworzony z podaniem masy i gestosci kalorycznej
            return (getMass() * getCaloricFactor() / 100);
        else //jesli posilek utworzony jako masa skladnikow odzywczych
            return (protein.nutrientEnergyValue() + carbohydrates.nutrientEnergyValue() + fat.nutrientEnergyValue());
    }
}
