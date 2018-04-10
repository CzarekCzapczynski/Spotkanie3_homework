package com.company.runner;

public class Cycling extends Running {
    protected int cadence;

    Cycling() {
        super();
    }

    Cycling(Time time, double distance, Runner runner) {
        super(time, distance, runner);
        this.resetCycling();
        this.calories = (int) (runner.bmr() * getSpeed() / 48);
    }

    Cycling(Time time, double distance, Runner runner, int cadence) {
        super(time, distance, runner);
        this.resetCycling();
        this.cadence = cadence;
        this.calories = (int) (runner.bmr() * getSpeed() / 48);
    }

    public void setCadence(int cadence) {
        this.cadence = cadence;
    }

    public int getCadence() {
        return cadence;
    }

    public void resetCycling() {
        this.cadence = 0;
        this.name = "Cycling";
    }

    public void printCycling() {
        this.printRunning();
        System.out.println("  Cadence: " + getCadence() + " rpm");
    }
}
