package com.company.runner;

public class Activity {
    protected String name;
    protected int calories;
    protected Time time;

    Activity() {
        resetActivity();
    }

    Activity(Time time) {
        resetActivity();
        this.time = time;
    }

    Activity(int calories, Time time) {
        resetActivity();
        this.calories = calories;
        this.time = time;
    }

    Activity(String name, int calories, Time time) {
        this.name = name;
        this.calories = calories;
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void resetActivity() {
        this.name = "Simple Activity";
        this.calories = 0;
        this.time = new Time(0, 0, 0);
    }

    public void printActivity() {
        System.out.println("Your activity parameters:");
        System.out.println("  Name: " + getName());
        System.out.print("  Time: ");
        time.printTime();
        System.out.println();
        System.out.println("  Calories: " + getCalories() + " kcal");
    }
}
