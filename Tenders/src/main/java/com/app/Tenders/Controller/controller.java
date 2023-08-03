package com.app.Tenders.Controller;

import com.app.Tenders.Entity.User;
import com.app.Tenders.Entity.tender;
import com.app.Tenders.Entity.userDTO;
import com.app.Tenders.Services.UserServices;
import com.app.Tenders.Services.tenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class controller {

    @Autowired
    private UserServices uservice;

    @Autowired
    private tenderService tservice;

    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/newUser")
    public String newUserPage(){
        return "newUser";
    }

    @GetMapping("/newtender")
    public String newTenderPage(){
        return "newTender";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute userDTO userl, Model m){
        System.out.println(userl.getUsername()+""+userl.getPassword());
        User user=uservice.login(userl.getUsername(),userl.getPassword());
        m.addAttribute("user",user);
        return "home";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        uservice.newUser(user);
        return "redirect:/";
    }

    @GetMapping("/home")
    public String home(Model m){
        List<tender> list=tservice.getTenders();
        m.addAttribute("list",list);
        return "home";
    }

    @PostMapping("/newTender")
    public String newTender(@ModelAttribute tender t){
        tservice.addTender(t);
        return "redirect:/home";
    }

}
