package com.company;

import java.sql.Array;

public class Main {

    public static void main(String[] args) {
        Person obj1 = new Person();
        Person obj2 = new Person("Michael",2000);
        Person obj3 = new Person("Alex",1998);
        Person obj4 = new Person("Juan",2005);
        Person obj5 = new Person();
        obj5.inputData();
        Person[] mas =  {obj1,obj2,obj3,obj4,obj5};
        for(Person i:mas)
        {
            i.printData();
        }
    }
}
