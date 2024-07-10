package com.example.flyweight.without_flyweight;

import com.example.flyweight.Car;
import com.example.flyweight.Model;
import com.example.flyweight.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class WithoutFlyweightExample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        List<Vehicle> carList = new ArrayList<>(2000000);
        Vehicle vehicle = null;
        for (int i = 0; i < 1000000; i++) {
            vehicle = new Car(Model.MODEL_X);
            vehicle.evaluatePrice(0);
            carList.add(vehicle);
        }
        Vehicle car = null;
        for (int i = 0; i < 1000000; i++) {
            car = new Car(Model.MODEL_Y);
            vehicle.evaluatePrice(10);
            carList.add(car);
        }

        System.out.println("Total number of cars=" + carList.size());
        System.out.println("Price of a less-than-one-year_old MODEL_X=" + vehicle.getPrice());
        System.out.println("Price of a more-than-ten-year_old MODEL_X=" + car.getPrice());

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory used with Flyweight: " + (memoryAfter - memoryBefore) / 1024 / 1024 + " MB");
    }
}
