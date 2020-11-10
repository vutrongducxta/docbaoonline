package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller

public class LogInController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/login")

    public String getlogin(Model model){
        model.addAttribute("user",new UserEntity());
        return "login";
    }
    @PostMapping("/login")

    public String login(HttpSession session, @ModelAttribute("user") UserEntity userEntity){
        UserEntity user = userRepository.findByUsername(userEntity.getUsername());
        if(user==null){return "redirect:/login?usernameIncorrect";}
        else if(!user.getPassword().equalsIgnoreCase(userEntity.getPassword()))
        {
            return "redirect:/login?passwordIncorrect";
        }
        session.setAttribute("username", user.getUsername());
        return "redirect:/";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/login?logout";

    }

}
