package com.example.challengefragmentsrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        ArrayList<Car> car = new ArrayList<>();
        car.add(new Car("volkswagen", "Polo"));
        car.add(new Car("mercedes", "E200"));
        car.add(new Car("nissan", "Almera"));
        car.add(new Car("mercedes", "E180"));
        car.add(new Car("volkswagen", "Kombi"));
        car.add(new Car("nissan", "Navara"));

        people = new ArrayList<>();
        people.add(new Person("Chuck", "Norris", "092309809", car.get(0)));
        people.add(new Person("Peter", "Pollock", "1111111111", car.get(1)));
        people.add(new Person("Chris", "James", "2222222222", car.get(2)));
        people.add(new Person("John", "Rambo", "3333333333", car.get(3)));
        people.add(new Person("Nelson", "Mandela", "4444444444", car.get(4)));
        people.add(new Person("Paul", "Bunting", "5555555555", car.get(5)));

    }
}
