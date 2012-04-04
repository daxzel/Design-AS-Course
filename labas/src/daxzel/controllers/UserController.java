package daxzel.controllers;

import daxzel.model.services.UserService;

import daxzel.model.services.RoleService;

import daxzel.model.domains.Role;
 
import daxzel.model.domains.User;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
 
@Controller
@RequestMapping("/users")
public class UserController {
 
	@Autowired
 	private UserService userService;
	
	@Autowired
 	private RoleService roleService;
	
	
	@RequestMapping("/delete/{userId}")
    public ModelAndView deleteUser(@PathVariable("userId")
                            Long id) 
    {       
    	userService.remove(id);
    	return new ModelAndView(new RedirectView("../"));
    }
	
    @RequestMapping(value="/add",method = RequestMethod.POST)
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
        return new ModelAndView("user", "findedUser", user);
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView newUser()  
    {
    	User user = new User();
    	ModelAndView modelView = new ModelAndView("add_user");
    	modelView.addObject("user", user);
    	java.util.List<Role> roles = roleService.getAll();
    	modelView.addObject("roleList", roles);
        return modelView;
    }
    
}
