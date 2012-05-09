package daxzel.controllers;

import daxzel.model.domains.Order;
import daxzel.model.services.OrderService;
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
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


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
        modelView.addObject("add", new Boolean(true));
        return modelView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView updateOrder(@PathVariable("id") Long id)
    {
        Order order = orderService.getByID(id);
        ModelAndView modelView = new ModelAndView("add_order");
        modelView.addObject("order", order);
        modelView.addObject("add", new Boolean(false));
        return modelView;
    }
}
