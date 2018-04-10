package com.company.runner;

import java.time.LocalDate;

public class Person {
    protected String name;
    protected LocalDate dateOfBirth;
    protected char sex;
    protected double dailyConsume;

    Person() {
    }

    Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dailyConsume = 0;
    }

    Person(String name, LocalDate dateOfBirth, char sex) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        dailyConsume = 0;
        setSex(sex);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setSex(char sex) {
        switch (sex) {
            case 'm':
                this.sex = 'M';
                break;
            case 'M':
                this.sex = sex;
                break;
            case 'f':
                this.sex = 'F';
                break;
            case 'F':
                this.sex = sex;
                break;
            default:
                break;
        }
    }

    public char getSex() {
        return sex;
    }

    public String sexToString() {
        if (this.sex == 'M') return "man";
        else if (this.sex == 'F') return "woman";
        return "";
    }

    public void setDailyConsume(double dailyConsume) {
        this.dailyConsume = dailyConsume;
    }

    public double getDailyConsume() {
        return dailyConsume;
    }

    public void addDailyConsume(double consume) {
        this.dailyConsume = +consume;
    }

    public void printDailyConsume() {
        System.out.printf("Your daily consume: %.2f", getDailyConsume());
        System.out.println(" kcal.");
    }

    public void eating(Meal meal) {
        this.addDailyConsume(meal.energyValue());
        this.printDailyConsume();
    }

    public void greeting() {
        System.out.println("Hello " + getName());
        System.out.println("You were born on " + getDateOfBirth());
        if ((this.sex != 'M') && (this.sex != 'F')) System.out.println("You're genderless. Please set your sex!");
        else System.out.println("You're a " + sexToString());
    }

}
