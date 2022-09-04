package com.company;


import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //first();
        // third();
        // fourth();
          fifth();
    }

    public static void first() {
        int[] monthDayCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 12};

        int monthNumber = 0;
        do {
            System.out.println("Enter number of month");
            while (!sc.hasNextInt()) {
                System.out.println("Wrong month number!");
                sc.next();
            }
            monthNumber = sc.nextInt();

        } while (monthNumber < 1 || monthNumber > 12);
        System.out.printf("Month - %s, days - %d%n", monthNumber, monthDayCount[monthNumber - 1]);
    }

    public static ArrayList<Integer> second() {
        int sum = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("Enter %d number", i + 1));
            while (!sc.hasNextInt()) {
                System.out.println("Wrong input! Try again");
                sc.next();
            }
            numbers.add(sc.nextInt());

            if (i < 5 && flag) {
                if (numbers.get(i) > 0) {
                    sum += numbers.get(i);
                } else {
                    sum = 0;
                    flag = false;
                }
            } else {
                if (!flag) {
                    sum += numbers.get(i);
                }
            }
        }
        if (flag) {
            System.out.println(String.format("sum = %d, added first group of 5 numbers", sum));
        } else {
            System.out.println(String.format("sum = %d, added second group of 5 numbers", sum));
        }
        return numbers;
    }

    public static void third() {
        int counter = 0;
        for (Integer i : second()) {
            if (i > 0) {
                counter++;
                if (counter == 1) {
                    System.out.println("Second positive number in array= " + i);
                }
            }
        }
    }

    public static void fourth() {
        int num = 0;
        int evenCount = 0;
        while (true) {
            System.out.println("Enter some number");
            while (!sc.hasNextInt()) {
                System.out.println("Wrong month number!");
                sc.next();
            }
            num = sc.nextInt();
            if (num < 0) {
                break;
            }
            if (num % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println(String.format("Even numbers - %d%n", evenCount));
    }

    public static void fifth() {
        Car[] cars =
                {new Car(), new Car("Car2", 2001, 4),
                        new Car("Car3", 1979, 4), new Car("Car4", 2012, 3)};
        ArrayList<Car> carsByYear = new ArrayList<>();

        for (Car i : cars) {
            if (carsByYear.isEmpty()) {
                carsByYear.add(i);
            } else {
                if (i.getYear() > carsByYear.get(carsByYear.size() - 1).getYear()) {
                    for (int j = 0; j < carsByYear.size(); j++) {
                        if (i.getYear() > carsByYear.get(j).getYear()) {
                            carsByYear.add(j, i);

                            break;
                        }
                    }
                } else {
                    carsByYear.add(i);
                }

            }

        }
        for (Car i : carsByYear) {
            i.print();
        }
    }


}

