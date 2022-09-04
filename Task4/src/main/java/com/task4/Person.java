package com.task4;

import com.task4.exception.IncorrectUsernameException;

public class Person {
    protected String name;
    protected String surname;
    protected String patronymic;
    protected int age;

    public Person(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = 18;
    }


    public Person() {
        this.name = "Sergey";
        this.surname = "Shcherbak";
        this.patronymic = "Yurijevich";
    }

    public String getFullName() throws IncorrectUsernameException {
        if (this.name == null) {
            throw new IncorrectUsernameException("Name is missing!");
        }
        if (this.surname == null) {
            throw new IncorrectUsernameException("Surname is missing!");
        }
        if (this.patronymic == null) {
            throw new IncorrectUsernameException("Patronymic is missing!");
        }
        return this.surname + " " + this.name + " " + this.patronymic;
    }

    public static Boolean isAdult(Person p) {
        return p.age > 18;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

}
