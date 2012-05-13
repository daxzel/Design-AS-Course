package daxzel.controllers;

import daxzel.model.domains.Order;
import daxzel.model.domains.Organization;
import daxzel.model.domains.Production;
import daxzel.model.services.OrderService;
import daxzel.model.services.OrganizationService;
import daxzel.model.services.ProductionService;
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
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private ProductionService productionService;


    @RequestMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id")
                                     Long id)
    {
        orderService.remove(id);
        return "redirect:/orders";
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order")
                                      Order order, BindingResult result)
    {
        orderService.add(order);
        return "redirect:/orders";
    }

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView showOrders()
    {
        return new ModelAndView("orders","orderList", orderService.getAll());
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView newOrder()
    {
        Order order = new Order();
        ModelAndView modelView = new ModelAndView("add_order");
        modelView.addObject("order", order);
        java.util.List<Organization> organizations = organizationService.getAll();
        modelView.addObject("organizationList", organizations);
        java.util.List<Production> productionList = productionService.getAll();
        modelView.addObject("productionList", productionList);
        modelView.addObject("add", new Boolean(true));
        return modelView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView updateOrder(@PathVariable("id") Long id)
    {
        Order order = orderService.getByID(id);
        ModelAndView modelView = new ModelAndView("add_order");
        modelView.addObject("order", order);
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
                Organization organization = organizationService.getOrganizationByName(text);
                this.setValue(organization);
            }

            public String getAsText() {
                Organization organization = (Organization) this.getValue();

                if (organization!=null)
                {
                    return organization.getName();
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
                Production production = productionService.getByID(Long.parseLong(text));
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
