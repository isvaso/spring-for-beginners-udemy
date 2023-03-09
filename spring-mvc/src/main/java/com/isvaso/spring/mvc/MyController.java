package com.isvaso.spring.mvc;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


@Controller
public class MyController {

    @RequestMapping("/")
    public String showIndexView() {
        return "index";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        model.addAttribute(
                "departments",
                getDepartmentsMap());

        model.addAttribute(
                "carBrands",
                getCarBrandsMap());

        model.addAttribute(
                "languages",
                getLanguagesMap());

        model.addAttribute("employee", new Employee());

        return "ask-emp-details-view";
    }

    @RequestMapping("/showDetails")
    public String showEmployeeDetails(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(
                    "departments",
                    getDepartmentsMap());

            model.addAttribute(
                    "carBrands",
                    getCarBrandsMap());

            model.addAttribute(
                    "languages",
                    getLanguagesMap());
            return "ask-emp-details-view";
        } else {
            return "show-emp-details-view";
        }
    }

    private Map<String, String> getCarBrandsMap() {
        Map<String, String> enumMap = new HashMap<>(10);
        for (CarBrands m : CarBrands.values()) {
            enumMap.put(m.getFullName(), m.toString());
        }
        return enumMap;
    }

    private Map<String, String> getDepartmentsMap() {
        Map<String, String> enumMap = new HashMap<>(10);
        for (Departmens m : Departmens.values()) {
            enumMap.put(m.getFullName(), m.toString());
        }
        return enumMap;
    }

    private Map<String, String> getLanguagesMap() {
        Map<String, String> enumMap = new HashMap<>(10);
        for (Languages m : Languages.values()) {
            enumMap.put(m.getFullName(), m.toString());
        }
        return enumMap;
    }
}
