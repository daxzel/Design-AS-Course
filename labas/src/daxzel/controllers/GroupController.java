package daxzel.controllers;

import daxzel.model.services.GroupService;
 
import daxzel.model.domains.Group;

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
@RequestMapping("/groups")
public class GroupController {
 	
	@Autowired
 	private GroupService groupService;
	
	
	@RequestMapping("/delete/{NCP}")
    public String deleteGroup(@PathVariable("NCP")
    			Long NCP) 
    {       
		groupService.removeGroupByNCP(NCP);
    	return "redirect:/groups";
    }
	
    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addGroup(@ModelAttribute("group")
                            Group group, BindingResult result) 
    {       
    	groupService.add(group);
    	return "redirect:/groups";
    }
 
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView showGroups() 
    {
    	return new ModelAndView("groups","groupList", groupService.getAll());
    }
    
    @RequestMapping(value="/{NCP}", method=RequestMethod.GET)
    public ModelAndView getByNCP(@PathVariable("NCP") Long NCP)  
    {
    	Group group = groupService.findGroupByNCP(NCP);
        return new ModelAndView("group", "findedGroup", group);
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView newUser()  
    {
    	Group group = new Group();
    	ModelAndView modelView = new ModelAndView("add_group");
    	modelView.addObject("group", group);
    	modelView.addObject("add", new Boolean(true));
        return modelView;
    }
    
    @RequestMapping(value="/edit/{NCP}", method=RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable("NCP") Long NCP)  
    {
    	Group group = groupService.findGroupByNCP(NCP);
    	ModelAndView modelView = new ModelAndView("add_group");
    	modelView.addObject("group", group);
    	modelView.addObject("add", new Boolean(true));
        return modelView;
    }
    
}