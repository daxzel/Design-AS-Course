package daxzel.controllers;

import daxzel.model.services.UserService;
 
import daxzel.model.domains.User;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
 
@Controller
@RequestMapping("/users")
public class UserController {
 
	@Autowired
 	private UserService userService;
	
    @RequestMapping(value="/new",method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user")
                            User user, BindingResult result) 
    {       
    	userService.add(user);
    	return new ModelAndView(new RedirectView(""));
    }
 
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView showUsers() 
    {
    	return new ModelAndView("users","userList", userService.getAll());
    }
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public ModelAndView getForName(@PathVariable("name") String name)  
    {
    	User user = userService.getUserByName(name);
        return new ModelAndView("user", "command", user);
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView newUser()  
    {
    	User user = new User();
        return new ModelAndView("user", "command", user);
    }
    
}
