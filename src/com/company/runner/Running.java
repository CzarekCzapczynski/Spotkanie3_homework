package com.company.runner;

public class Running extends Activity {
    protected double distance, speed, peace;
    protected Runner runner;

    Running() {
        super();
        this.resetRunning();
    }

    Running(Time time, double distance, Runner runner) {
        super(time);
        this.name = "Running";
        this.distance = distance;
        this.runner = runner;
        //calculates speed in km/h
        if (time.timeInHours() > 0) {

            this.speed = distance / time.timeInHours();
        } else
            this.speed = 0;
        //calculates peace in min/km
        if (distance > 0)
            this.peace = time.timeInMinutes() / distance;
        else
            this.peace = 0;
        //calculates calories
        this.calories = (int) (runner.bmr() * getSpeed() / 24);
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    public double getPeace() {
        return peace;
    }

    public void resetRunning() {
        this.resetActivity();
        this.distance = 0.0;
        this.speed = 0.0;
        this.peace = 0.0;
        this.name = "Running";
    }

    public void printRunning() {
        this.printActivity();
        System.out.printf("  Distance: %.2f", getDistance());
        System.out.println(" km");
        System.out.printf("  Speed: %.2f", getSpeed());
        System.out.println(" km/h");
        System.out.printf("  Peace: %.2f", getPeace());
        System.out.println(" min/km");
    }
}