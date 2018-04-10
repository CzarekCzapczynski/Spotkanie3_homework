package com.company.runner;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void printMenu() {
        System.out.println("Choose:");
        System.out.println("0 - End");
        System.out.println("1 - Eat yogurt");
        System.out.println("2 - Eat lunch");
        System.out.println("3 - Add activity");
        System.out.println("4 - Add running");
        System.out.println("5 - Add cycling");
        System.out.println("9 - Go to the next day");
    }

    public static void main(String[] args) throws IOException {

        double week[][] = new double[7][2];
        int day = 0;

        Runner czarek;
        LocalDate testDateOfBirth;
        char choice, ignore;
        Meal yogurt, lunch;

        testDateOfBirth = LocalDate.of(1977, 8, 14);
        czarek = new Runner("Czarek", testDateOfBirth, 'm', 186, 72);

        yogurt = new Meal(180, 67);
        lunch = new Meal(80, 120, 100);


        czarek.greeting();
        czarek.runnerParams();

        do {
            System.out.println("-------------------------");
            printMenu();
            System.out.println("-------------------------");

            choice = (char) System.in.read();

            //oczyszcza wejscie z innych znakow
            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');

            switch (choice) {
                case '0': {
                    System.out.println("Your week in numbers:");

                    for (int i = 1; i <= day; i++) {
                        System.out.println("-------Day #" + i + "--------");
                        System.out.printf("Daily consume: %.2f", week[i - 1][0]);
                        System.out.println(" kcal.");
                        System.out.printf("Daily energy requirement: %.2f", week[i - 1][1]);
                        System.out.println(" kcal.");
                    }
                    System.out.println("See you in next week!");
                    return;
                }
                case '1': {
                    System.out.println("eating yogurt...");
                    czarek.eatingRunner(yogurt);
                    break;
                }
                case '2': {
                    System.out.println("eating lunch...");
                    czarek.eatingRunner(lunch);
                    break;
                }
                case '3': {
                    Time badmintonTime = new Time(1, 30, 0);
                    Activity badminton = new Activity("Badminton", 605, badmintonTime);

                    System.out.println("doing activity...");
                    badminton.printActivity();
                    czarek.doingActivity(badminton.getCalories());
                    break;
                }
                case '4': {
                    Time runningTime = new Time(0, 51, 0);
                    Running dailyRun = new Running(runningTime, 10.51, czarek);

                    System.out.println("running...");
                    dailyRun.printRunning();
                    czarek.doingActivity(dailyRun.getCalories());
                    break;
                }
                case '5': {
                    Time bikeTime = new Time(1, 58, 49);
                    Cycling sundayRide = new Cycling(bikeTime, 43.55, czarek, 58);

                    System.out.println("cycling...");
                    sundayRide.printCycling();
                    czarek.doingActivity(sundayRide.getCalories());
                    break;
                }
                case '9': {
                    if (day <= 6) {
                        week[day][0] = czarek.getDailyConsume();
                        week[day][1] = czarek.getDailyRequirement();
                        day++;
                    } else System.out.println("Week is full!");

                    czarek.setDailyConsume(0);
                    czarek.setDailyRequiremnt(czarek.bmr());
                    break;
                }
                default:
                    return;
            }
        } while (choice != '0');
    }
}
