package daxzel.controllers;

import daxzel.model.domains.Organization;
import daxzel.model.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: daxzel
 * Date: 4/9/12
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;


    @RequestMapping("/delete/{id}")
    public String deleteOrganization(@PathVariable("id")
                             Long id)
    {
        organizationService.remove(id);
        return "redirect:/organizations";
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addOrganization(@ModelAttribute("organization")
                                      Organization organization, BindingResult result)
    {
        organizationService.add(organization);
        return "redirect:/organizations";
    }

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView showOrganizations()
    {
        return new ModelAndView("organizations","organizationList", organizationService.getAll());
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView newOrganization()
    {
        Organization organization = new Organization();
        ModelAndView modelView = new ModelAndView("add_organization");
        modelView.addObject("organization", organization);
        modelView.addObject("add", new Boolean(true));
        return modelView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView updateOrganization(@PathVariable("id") Long id)
    {
        Organization organization = organizationService.getByID(id);
        ModelAndView modelView = new ModelAndView("add_organization");
        modelView.addObject("organization", organization);
        modelView.addObject("add", new Boolean(false));
        return modelView;
    }

}
