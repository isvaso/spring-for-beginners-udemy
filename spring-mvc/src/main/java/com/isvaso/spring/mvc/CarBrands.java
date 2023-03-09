package com.isvaso.spring.mvc;

public enum CarBrands implements FormEnum {
    Audi("Audi"),
    BWM("BMW"),
    MB("Mercedes-Benz");

    private String fullName;
    private int size;

    private CarBrands(String fullName) {
        this.fullName = fullName;
        this.size++;
    }

    public String getFullName() {
        return fullName;
    }
}
