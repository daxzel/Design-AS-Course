package daxzel.controllers;

import daxzel.model.services.KindAdService;

import daxzel.model.domains.KindAd;

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
@RequestMapping("/kindsAd")
public class KindAdController {
 
	@Autowired
 	private KindAdService kindAdService;
	
	
	@RequestMapping("/delete/{key}")
    public String deleteKindAd(@PathVariable("key")
                            Long id) 
    {       
    	kindAdService.remove(id);
    	return "redirect:/kindsAd";
    }
	
    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addKindAd(@ModelAttribute("kindAd")
    				KindAd user, BindingResult result) 
    {       
    	kindAdService.add(user);
    	return "redirect:/kindsAd";
    }
 
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView showKindsAd() 
    {
    	return new ModelAndView("kindsAd","kindsAdList", kindAdService.getAll());
    }
    
    @RequestMapping(value="/{key}", method=RequestMethod.GET)
    public ModelAndView getForName(@PathVariable("key") Long key)  
    {
    	KindAd kindAd = kindAdService.getByID(key);
        return new ModelAndView("kindAd", "findedKindAd", kindAd);
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView newKindAd()  
    {
    	KindAd kindAd = new KindAd();
    	ModelAndView modelView = new ModelAndView("add_kindAd");
    	modelView.addObject("kindAd", kindAd);
    	modelView.addObject("add", new Boolean(true));
        return modelView;
    }
    
    @RequestMapping(value="/edit/{key}", method=RequestMethod.GET)
    public ModelAndView updateKindAd(@PathVariable("key") Long key)  
    {
    	KindAd kindAd = kindAdService.getByID(key);
    	ModelAndView modelView = new ModelAndView("add_kindAd");
    	modelView.addObject("kindAd", kindAd);
    	modelView.addObject("add", new Boolean(false));
        return modelView;
    }
    
}