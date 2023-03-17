package com.isvaso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @GetMapping({"/", ""})
    public String showStartPage() {
        return "index-view";
    }

    @GetMapping("/index")
    public String showIndex() {
        return "index-view";
    }

    @GetMapping("/managers_info")
    public String showManagersInfo() {
        return "managers-info-view";
    }

    @GetMapping("hr_info")
    public String showHrInfo() {
        return "hr-info-view";
    }
}
