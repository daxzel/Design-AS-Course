package daxzel.controllers;

import daxzel.model.services.RoleService;

import daxzel.model.domains.Role;

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
@RequestMapping("/roles")
public class RoleController {
 
	@Autowired
 	private RoleService roleService;
	
    @RequestMapping(value="/create", method=RequestMethod.GET)
    public ModelAndView createRoles()  
    {
    	roleService.create();
        return new ModelAndView(new RedirectView("/"));
    }

    
}