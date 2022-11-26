package com.doggy;

public class Car {

    private String name;
    private String type;

    public Car(String name, String type) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }
}
