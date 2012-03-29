package daxzel.controllers;

import daxzel.model.DAO.impl.UserDAOImpl;
 
import daxzel.model.domains.User;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@SessionAttributes
@RequestMapping("/user")
public class UserController {
 
	
	UserDAOImpl dao;
	
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addYser(@ModelAttribute("user")
                            User user, BindingResult result) {       
        return new ModelAndView("home", "message", message);

    }
 
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String showUsers(Map<String, Object> map) {
    	map.put("userList", UserDAOImpl.getAll());
    	return "user";
    }
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public ModelAndView getForName(@PathVariable("name") String name)  {
    	
        return new ModelAndView("user", "command", new User());
    }
    
}
