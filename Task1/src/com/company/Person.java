package com.company;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {
    private String name;
    private int birthYear;

    Person() {
        this.name = "Mike";
        this.birthYear = Calendar.getInstance().get(Calendar.YEAR);
    }

    Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int age() {
        return Calendar.getInstance().get(Calendar.YEAR) - birthYear;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name: ");
        if (sc.hasNext()) {
            this.name = sc.nextLine();
        } else {
            System.out.println("Incorrect name input. Try again");
        }

        do {
            System.out.println("Enter birth year: ");
            while (!sc.hasNextInt() ) {
                System.out.println("Incorrect year value input. Try again");
                sc.next();
            }
            this.birthYear = sc.nextInt();
        } while (this.birthYear <= 0);

    }

    public void printData() {
        System.out.printf(" Name - %s; Birth year - %s\n", this.name, this.birthYear);

    }
}
