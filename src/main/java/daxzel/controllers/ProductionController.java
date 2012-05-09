package daxzel.controllers;

import daxzel.model.domains.Production;
import daxzel.model.services.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/10/12
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/production")
public class ProductionController {

    @Autowired
    private ProductionService productionService;


    @RequestMapping("/delete/{id}")
    public String deleteProduction(@PathVariable("id")
                             Long id)
    {
        productionService.remove(id);
        return "redirect:/productions";
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addProduction(@ModelAttribute("production")
                            Production production, BindingResult result)
    {
        productionService.add(production);
        return "redirect:/productions";
    }

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView showProduction()
    {
        return new ModelAndView("productions","productionList", productionService.getAll());
    }

    @RequestMapping(value="/add", method= RequestMethod.GET)
    public ModelAndView newProduction()
    {
        Production production = new Production();
        ModelAndView modelView = new ModelAndView("add_production");
        modelView.addObject("production", production);
        modelView.addObject("add", new Boolean(true));
        return modelView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView updateProduction(@PathVariable("id") Long id)
    {
        Production production = productionService.getByID(id);
        ModelAndView modelView = new ModelAndView("add_production");
        modelView.addObject("production", production);
        modelView.addObject("add", new Boolean(false));
        return modelView;
    }
}
