package com.spring.springbootapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.Data;


@Data
@Controller
public class SpringbootController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signin")
    public String showSignupPage(Model model) {
        model.addAttribute("springbootForm", new SignupForm());
        return "signin";
    }

    @PostMapping("/register")
    public String registerUser(
        @Valid @ModelAttribute("springbootForm") SignupForm form,
        BindingResult result,
        Model model,
        HttpServletRequest request
    ) {

        if (result.hasErrors()) {
            return "signin";
        }

        String rawPassword = form.getPassword();
        String hashedPassword = passwordEncoder.encode(rawPassword);
        
        try {

            request.login(form.getEmail(), rawPassword);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        
        form.setPassword(hashedPassword);
        return "redirect:/top";
    }

    @GetMapping("/top")
    public String showTopPage() {
        return "top";
    }

}