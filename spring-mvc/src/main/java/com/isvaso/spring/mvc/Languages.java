package com.isvaso.spring.mvc;

public enum Languages {
    EN("English"),
    DE("Deutch"),
    FR("French");

    private String fullName;
    private int size;

    private Languages(String fullName) {
        this.fullName = fullName;
        this.size++;
    }

    public String getFullName() {
        return fullName;
    }
}
