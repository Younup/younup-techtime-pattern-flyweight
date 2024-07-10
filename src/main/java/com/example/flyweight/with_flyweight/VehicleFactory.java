package com.example.flyweight.with_flyweight;

import com.example.flyweight.Car;
import com.example.flyweight.Model;
import com.example.flyweight.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {
    private static final Map<Model, Vehicle> vehiclesCache = new HashMap<>();

    public static Vehicle createVehicle(Model model) {
        return vehiclesCache.computeIfAbsent(model, Car::new);
    }

}
