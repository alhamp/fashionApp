package com.launchacademy.giantleap.controllers;
import com.launchacademy.giantleap.models.FashionItem;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fashion")
public class FormController {


    @GetMapping({"/new"})
    public String getNewForm (Model model, Authentication authentication) {
        FashionItem fashionItem = new FashionItem();
        model.addAttribute("fashionItem", fashionItem);

        return "root/new";
    }
    }
