package com.company.runner;

import java.time.LocalDate;

public class Runner extends Person {
    private int age, height, weight;
    private double dailyRequirement;

    Runner() {
        super();
    }

    Runner(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }

    Runner(String name, LocalDate dateOfBirth, char sex) {
        super(name, dateOfBirth, sex);
    }

    Runner(String name, LocalDate dateOfBirth, char sex, int height, int weight) {
        super(name, dateOfBirth, sex);
        this.height = height;
        this.weight = weight;
        this.dailyRequirement = bmr();
    }

    public Runner(Runner runner) {
        this.dailyConsume = runner.dailyConsume;
        this.dailyRequirement = runner.dailyRequirement;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
//  calculate runner's age in years
        LocalDate now = LocalDate.now();
        age = now.getYear() - getDateOfBirth().getYear();
        return age;
    }

    public double bmi() {
//  calculate runner's BMI (Body Mass Index)
//  BMI = weight (kg) ÷ height2 (m2)
        double bmi;

        bmi = getWeight() / Math.pow(((double) getHeight() / 100), 2);
        return bmi;
    }

    public double bmr() {
//  calculate runner's BMR (Basal Metabolism Rate)
//  for woman        BMR = (10 × weight in kg) + (6.25 × height in cm) - (5 × age in years) - 161
//  for man        BMR = (10 × weight in kg) + (6.25 × height in cm) - (5 × age in years) + 5
        double bmr;
        int sexFactor;
        if ((getSex() == 'M') || (getSex() == 'F')) {
            sexFactor = ((getSex() == 'M') ? 5 : -161);
            bmr = 10 * getWeight() + 6.25 * getHeight() - 5 * getAge() + sexFactor;
            return bmr;
        } else return 0;
    }

    public void setDailyRequiremnt(double dailyRequirement) {
        this.dailyRequirement = dailyRequirement;
    }

    public double getDailyRequirement() {
        return dailyRequirement;
    }

    public void addDailyRequiremnt(double energy) {
        this.dailyRequirement += energy;
    }

    public void printDailyEnergyRequirement() {
        System.out.printf("Your daily energy requirement: %.2f", getDailyRequirement());
        System.out.println(" kcal.");
    }

    public void eatingRunner(Meal meal) {
        this.eating(meal);
        this.addDailyRequiremnt(-meal.energyValue());
        this.printDailyEnergyRequirement();
    }

    public void doingActivity(double energy) {
        this.addDailyRequiremnt(energy);
        this.printDailyEnergyRequirement();
    }

    public void runnerParams() {
        System.out.print(getName());
        System.out.printf("'s BMI: %.2f", bmi());
        System.out.println(" kg/m2");
        System.out.print(getName());
        System.out.printf("'s BMR: %.2f", bmr());
        System.out.println(" kcal/day");
        System.out.println("-------------------------");
    }
}
