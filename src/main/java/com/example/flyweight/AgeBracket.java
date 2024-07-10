package com.example.flyweight;

public enum AgeBracket {

    NEW(0, 0, 0.0),
    FAIRLY_NEW(1, 5, 0.2),
    MIDDLE_AGED(6, 10, 0.5),
    OLD(11, Integer.MAX_VALUE, 0.7);

    private final int minAge;
    private final int maxAge;
    private final double discount;

    AgeBracket(int minAge, int maxAge, double discount) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.discount = discount;
    }

    public static AgeBracket getAgeBracket(int ageInYears) {
        for (AgeBracket bracket : values()) {
            if (ageInYears >= bracket.minAge && ageInYears <= bracket.maxAge) {
                return bracket;
            }
        }
        throw new IllegalArgumentException("Invalid age: " + ageInYears);
    }

    public double getDiscount() {
        return discount;
    }
}
