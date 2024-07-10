package com.example.flyweight;

public class Car implements Vehicle {

    private final Model model;
    private int price = 0;

    public Car(Model model) {
        this.model = model;
    }

    @Override
    public String getPrice() {
        return price + Price.devise;
    }


    @Override
    public void evaluatePrice(int ageInYears) {
        int price = switch (model) {
            case MODEL_X:
                yield 20000;
            case MODEL_Y:
                yield 25000;
            case MODEL_Z:
                yield 30000;
        };

        AgeBracket ageBracket = AgeBracket.getAgeBracket(ageInYears);
        this.price = (int) (price - (ageBracket.getDiscount() * price));
    }

}
