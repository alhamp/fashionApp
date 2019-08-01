package com.launchacademy.giantleap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class FashionItemController {
    @GetMapping("/")
    public String index() {
      return "fashion/homePage";
    }

    @GetMapping("/list")
    public String list() {return "fashion/list";}

    @GetMapping("/show/{id}")
<<<<<<< HEAD
    public String show() { return "fashion/show"; }
=======
    public String show() {
      return "fashion/show";
    }
>>>>>>> d25804f143eaa0088fd62ad1bd742375078513de
}