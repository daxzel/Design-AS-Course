package daxzel.controllers;
 
import daxzel.domains.User;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@SessionAttributes
public class UserController {
 
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addYser(@ModelAttribute("user")
                            User user, BindingResult result) {
 
        System.out.println("Name:" + user.getName());
 
        String message = "Name:" + user.getName();
        
        return new ModelAndView("home", "message", message);
        
        //return "redirect:users.html";
    }
 
    @RequestMapping("/users")
    public ModelAndView showUsers() {
 
        return new ModelAndView("user", "command", new User());
    }
}
