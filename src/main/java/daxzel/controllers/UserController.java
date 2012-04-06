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
 
@Controller
@RequestMapping("/users")
public class UserController {
 
	@Autowired
 	private UserService userService;
	
	@Autowired
 	private RoleService roleService;
	
	
	@RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId")
                            Long id) 
    {       
    	userService.remove(id);
    	return "redirect:/users";
    }
	
    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")
                            User user, BindingResult result) 
    {       
    	userService.add(user);
    	return "redirect:/users";
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
    	modelView.addObject("add", new Boolean(true));
    	java.util.List<Role> roles = roleService.getAll();
    	modelView.addObject("roleList", roles);
        return modelView;
    }
    
    @RequestMapping(value="/edit/{name}", method=RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable("name") String name)  
    {
    	User user = userService.getUserByName(name);
    	ModelAndView modelView = new ModelAndView("add_user");
    	modelView.addObject("user", user);
    	modelView.addObject("add", new Boolean(false));
    	java.util.List<Role> roles = roleService.getAll();
    	modelView.addObject("roleList", roles);
        return modelView;
    }
    
}
