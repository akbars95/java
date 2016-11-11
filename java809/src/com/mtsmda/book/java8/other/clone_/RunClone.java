package com.mtsmda.book.java8.other.clone_;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by dminzat on 11/11/2016.
 */
public class RunClone {

    public static void main(String[] args) {
        User user = new User(15, "ivanovici", LocalDate.of(2015, 10, 05));
        System.out.println(user);

        User userClone = null;
        try {
           userClone = (User) user.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(userClone);
        System.out.println(user.equals(userClone));
        System.out.println(user.hashCode() == userClone.hashCode());
        userClone.setUserId(19);
        System.out.println("after change");
        System.out.println(user);
        System.out.println(userClone);

        System.out.println("Without impl Cloneable interface");
        ModelWithoutClone modelWithoutClone = new ModelWithoutClone("Klim");
        ModelWithoutClone modelWithoutCloneClone = null;
        try {
            modelWithoutCloneClone = (ModelWithoutClone) modelWithoutClone.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("EXCEPTION - " + e.getMessage());
        }
        System.out.println(modelWithoutClone);
        System.out.println(modelWithoutCloneClone);

        System.out.println("---------------------------");
        Car car = new Car(19, "AUdi", new CarDetails("very good auto!"));
        System.out.println(car);
        Car carClone = null;
        try {
            carClone = (Car) car.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("EXCEPTION - " + e.getMessage());
        }
        System.out.println(carClone);
        carClone.setCarDetails(new CarDetails("null"));
        System.out.println(car);
        System.out.println(carClone);
        carClone.getCarDetails().setCarDescription("nuuu");
        System.out.println(car);
        System.out.println(carClone);

    }

}