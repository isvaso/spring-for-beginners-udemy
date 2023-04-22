package com.isvaso.spring.mvc;

import com.isvaso.spring.mvc.validation.CheckEmail;
import jakarta.validation.constraints.*;

public class Employee {

//    @Size(min = 2, message = "Name must be between 2 and 50 characters")
    @NotBlank(message = "Must not contain only spaces")
    private String name;
//    @Size(min = 2, max = 20, message = "Surname must be between 2 and 50 characters")
    @NotBlank(message = "Must not contain only spaces")
    private String surname;

    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}",
            message = "The phone must be in the form XXX-XX-XX")
    private String phoneNumber;
    @CheckEmail(value = "@ya.ru", message = "Must end with @ya.ru")
    private String email;
    @NotEmpty(message = "Can't be empty")
    private String department;
    @Min(value = 100, message = "Cannot be less than 100")
    private int salary;
    @NotEmpty(message = "Can't be empty")
    private String carBrand;
    @NotEmpty(message = "Can't be empty")
    private String[] languages;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
