package com.company.runner;

public class Time {
    private int hours, minutes, seconds;

    Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int timeInSeconds() {
        return hours * 3600 + minutes * 60 + this.seconds;
    }

    public double timeInMinutes() {
        return (double) hours * 3600.0 + (double) minutes + (double) seconds / 60;
    }

    public double timeInHours() {
        return (double) hours + (double) minutes / 60 + (double) seconds / 3600;
    }

    public void printTime() {
        System.out.print(this.hours + "h " + this.minutes + "min " + this.seconds + "s ");
    }
}
