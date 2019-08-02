package com.launchacademy.giantleap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class FashionItemController {
    @GetMapping("/")
    public String index() {
      return "fashion/homePage";
    }

    @GetMapping("/list")
    public String list(@RequestParam(value="budget", required = false) Integer budget,
        @RequestParam(value="style", required=false) String style) {
      return "fashion/list";
    }

    @GetMapping("/about")
    public String about() { return "fashion/about"; }


    @GetMapping("/show/{id}")
    public String show() { return "fashion/show"; }
}
