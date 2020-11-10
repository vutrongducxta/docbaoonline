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
public class RegistrationController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/regist")

    public String getlogin(Model model) {
        model.addAttribute("user", new UserEntity());
        return "regist";
    }
    @PostMapping("/regist")

    public String login(HttpSession session, @ModelAttribute("user") UserEntity userEntity){
        UserEntity user = userRepository.findByUsername(userEntity.getUsername());
        if(user!=null){return "redirect:/regist?usernameExisted";}
        userRepository.save(userEntity);
        session.setAttribute("username", userEntity.getUsername());
        return "redirect:/";
    }
}
