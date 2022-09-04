package com.task4;

import java.util.ArrayList;
import java.util.Arrays;

public class Student extends Person {
    private String group;
    private ArrayList<Integer> marks;

    public Double getMarksAverage() {
        Double avg = 0.0;
        for (Integer i : marks) {
            avg += i;
        }
        avg = avg / marks.size();
        return avg;
    }

    public static Student getBetterStudent(Student... st) {
        ArrayList<Double> avgMarks = new ArrayList<>();
        Double bestMark = 0.0;
        Student bestStudent = new Student();
        for (int i = 0; i < st.length; i++) {
            avgMarks.add(st[i].getMarksAverage());
            if (avgMarks.get(i) > bestMark) {
                bestMark = avgMarks.get(i);
                bestStudent = st[i];
            }
        }
        return bestStudent;
    }

    public Student() {
        super();
        this.group = "IKM-219d";
        marks = new ArrayList<>(Arrays.asList(5, 5, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5));
        marksValidation();
    }

    public Student(String surname, String name, String patronymic, String group, ArrayList<Integer> marks) {
        super(surname, name, patronymic);
        this.group = group;
        this.marks = marks;
        marksValidation();
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
        marksValidation();
    }

    public String getGroup() {
        return group;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public Boolean isExcellent() {
        for (Integer i : marks) {
            if (i < 5) {
                return false;
            }
        }
        return true;
    }

    private void marksValidation() {
        for (int i = 0; i < this.marks.size() - 1; i++) {
            if (this.marks.get(i) < 0 || this.marks.get(i) > 5) {
                this.marks.remove(i);
            }
        }
    }
}
