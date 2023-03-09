package com.isvaso.spring.mvc;

public enum Departmens implements FormEnum {
    HR("Human Resources"),
    ADS("Advertisement"),
    IT("Information Technologies");

    private String fullName;
    private int size;

    private Departmens(String fullName) {
        this.fullName = fullName;
        this.size++;
    }

    public String getFullName() {
        return fullName;
    }
}
