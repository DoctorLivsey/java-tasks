package com.task4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = new Student("Alexandrenko", "Alexandr", "Alexandrovich", "IKM-228", new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 3, 3, 3, 5, 4, 3, 5, 2)));
        Student st3 = new Student("Alexandrov", "Alexandr", "Alexandrovich", "IKM-228", new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 3, 3, 3, 5, 4, 3, 5, 2)));
        Student st4 = new Student("Ivanov", "Alexandr", "Alexandrovich", "IKM-228", new ArrayList<>(Arrays.asList(4, 4, 4, 4, 2, 3, 3, 3, 5, 4, 3, 5, 2)));
        Student st5 = new Student("Andreev", "Alexandr", "Alexandrovich", "IKM-228", new ArrayList<>(Arrays.asList(3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,1,1,1,1)));
        Student bestStudent = Student.getBetterStudent(st1, st2, st3, st4,st5);
        System.out.println(String.format("best student  - %s %s with %.1f average mark",bestStudent.surname,bestStudent.name,bestStudent.getMarksAverage()));
    }
}
