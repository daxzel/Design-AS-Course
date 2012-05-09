package daxzel.controllers;

import daxzel.model.domains.Sale;
import daxzel.model.services.SaleService;
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
 * Time: 12:41 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;


    @RequestMapping("/delete/{id}")
    public String deleteSale(@PathVariable("id")
                              Long id)
    {
        saleService.remove(id);
        return "redirect:/sales";
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order")
                               Sale sale, BindingResult result)
    {
        saleService.add(sale);
        return "redirect:/sales";
    }

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView showSales()
    {
        return new ModelAndView("sales","saleList", saleService.getAll());
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView newSale()
    {
        Sale sale = new Sale();
        ModelAndView modelView = new ModelAndView("add_sale");
        modelView.addObject("sale", sale);
        modelView.addObject("add", new Boolean(true));
        return modelView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView updateSale(@PathVariable("id") Long id)
    {
        Sale sale = saleService.getByID(id);
        ModelAndView modelView = new ModelAndView("add_sale");
        modelView.addObject("sale", sale);
        modelView.addObject("add", new Boolean(false));
        return modelView;
    }


}
