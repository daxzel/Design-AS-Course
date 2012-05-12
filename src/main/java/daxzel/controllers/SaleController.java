package daxzel.controllers;

import daxzel.model.domains.Organization;
import daxzel.model.domains.Product;
import daxzel.model.domains.Production;
import daxzel.model.domains.Sale;
import daxzel.model.services.OrganizationService;
import daxzel.model.services.ProductionService;
import daxzel.model.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;

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

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private ProductionService productionService;


    @RequestMapping("/delete/{id}")
    public String deleteSale(@PathVariable("id")
                              Long id)
    {
        saleService.remove(id);
        return "redirect:/sales";
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addSale(@ModelAttribute("sale")
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
        java.util.List<Organization> organizations = organizationService.getAll();
        modelView.addObject("organizationList", organizations);
        java.util.List<Production> productionList = productionService.getAll();
        modelView.addObject("productionList", productionList);
        modelView.addObject("add", new Boolean(true));
        return modelView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView updateSale(@PathVariable("id") Long id)
    {
        Sale sale = saleService.getByID(id);
        ModelAndView modelView = new ModelAndView("add_sale");
        modelView.addObject("sale", sale);
        java.util.List<Organization> organizations = organizationService.getAll();
        modelView.addObject("organizationList", organizations);
        java.util.List<Production> productionList = productionService.getAll();
        modelView.addObject("productionList", productionList);
        modelView.addObject("add", new Boolean(false));
        return modelView;
    }

    @InitBinder
    protected void initBinderOrganization(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Organization.class, new PropertyEditorSupport() {

            public void setAsText(String text) {
                Organization organization = organizationService.getByID(Long.valueOf(text));
                this.setValue(organization);
            }

            public String getAsText() {
                Organization organization = (Organization) this.getValue();

                if (organization!=null)
                {
                    return organization.getKey().toString();
                }
                else
                {
                    return null;
                }
            }
        });
    }

    @InitBinder
    protected void initBinderProduction(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Production.class, new PropertyEditorSupport() {

            public void setAsText(String text) {
                Production production = productionService.getByID(Long.valueOf(text));
                this.setValue(production);
            }

            public String getAsText() {
                Production production = (Production) this.getValue();

                if (production!=null)
                {
                    return production.getKey().toString();
                }
                else
                {
                    return null;
                }
            }
        });
    }





}
