package daxzel.controllers;

import daxzel.controllers.helpers.CommandObjectForAdCosts;
import daxzel.controllers.helpers.CommandProductHelper;
import daxzel.model.domains.Product;
import daxzel.model.services.ProductService;
import daxzel.model.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/13/12
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/orders_by_product/get")
    public ModelAndView getOrderReport(@ModelAttribute("productHelper")
                                           CommandProductHelper commandProductHelper)
    {
        ModelAndView modelView = new ModelAndView("report_orders_by_product");

        Product product = commandProductHelper.getProduct();

        modelView.addObject("orderList", product.getOrders());
        return modelView;
    }

    @RequestMapping(value="/orders_by_product")
    public ModelAndView getOrderReport()
    {
        ModelAndView modelView = new ModelAndView("input_product_for_orders");
        java.util.List<Product> products = productService.getAll();
        modelView.addObject("productList", products);

        CommandProductHelper commandProductHelper = new CommandProductHelper();

        modelView.addObject("productHelper", commandProductHelper);

        return modelView;
    }

    @RequestMapping(value="/ad_cost_by_product/get")
    public ModelAndView getOrderReport(@ModelAttribute("commandObjectForAdCosts")
                                           CommandObjectForAdCosts commandObjectForAdCosts)
    {
        ModelAndView modelView = new ModelAndView("report_ad_cost_by_product");

        Product product = commandObjectForAdCosts.getProduct();

        Date begin = commandObjectForAdCosts.getDateBegin();

        Date end = commandObjectForAdCosts.getDateEnd();

        modelView.addObject("result", reportService.getShareAdCosts(product,begin,end));
        return modelView;
    }


    @RequestMapping(value="/ad_cost_by_product")
    public ModelAndView getAdCostsReport()
    {
        ModelAndView modelView = new ModelAndView("input_ad_cost_by_products");
        java.util.List<Product> products = productService.getAll();
        modelView.addObject("productList", products);

        CommandObjectForAdCosts commandObjectForAdCosts = new CommandObjectForAdCosts();

        modelView.addObject("commandObjectForAdCosts", commandObjectForAdCosts);

        return modelView;
    }

    @RequestMapping(value="/dynamics_changes_sales/get")
    public ModelAndView getDynamicSales(@ModelAttribute("productHelper")
                                            CommandProductHelper commandProductHelper)
    {
        ModelAndView modelView = new ModelAndView("report_average_cost_product");

        Product product = commandProductHelper.getProduct();

        modelView.addObject("result", reportService.getMonthsAmountsMargins(product));
        return modelView;
    }


    @RequestMapping(value="/dynamics_changes_sales")
    public ModelAndView getDynamicSalesInput()
    {
        ModelAndView modelView = new ModelAndView("input_average_cost_product");
        java.util.List<Product> products = productService.getAll();
        modelView.addObject("productList", products);

        CommandProductHelper commandProductHelper = new CommandProductHelper();

        modelView.addObject("productHelper", commandProductHelper);

        return modelView;
    }


    @RequestMapping(value="/cost_by_product/get")
    public ModelAndView getCostProduct(@ModelAttribute("commandObjectForCosts")
                                       CommandObjectForAdCosts commandObjectForAdCosts)
    {
        ModelAndView modelView = new ModelAndView("report_cost_by_product");

        Product product = commandObjectForAdCosts.getProduct();

        Date begin = commandObjectForAdCosts.getDateBegin();

        Date end = commandObjectForAdCosts.getDateEnd();

        modelView.addObject("result", reportService.getProductCosts(product));
        return modelView;
    }


    @RequestMapping(value="/cost_by_product")
    public ModelAndView CostProduct()
    {
        ModelAndView modelView = new ModelAndView("input_cost_by_product");
        java.util.List<Product> products = productService.getAll();
        modelView.addObject("productList", products);

        CommandObjectForAdCosts commandObjectForAdCosts = new CommandObjectForAdCosts();

        modelView.addObject("commandObjectForCosts", commandObjectForAdCosts);

        return modelView;
    }


    @RequestMapping(value="/dynamics_costs/get")
    public ModelAndView getDynamicsCosts(@ModelAttribute("commandObjectForCosts")
                                       CommandObjectForAdCosts commandObjectForAdCosts)
    {
        ModelAndView modelView = new ModelAndView("report_dynamics_costs");

        Product product = commandObjectForAdCosts.getProduct();

        Date begin = commandObjectForAdCosts.getDateBegin();

        Date end = commandObjectForAdCosts.getDateEnd();

        modelView.addObject("result", reportService.getMonthsCostPrices(product));
        return modelView;
    }


    @RequestMapping(value="/dynamics_costs")
    public ModelAndView DynamicsCosts()
    {
        ModelAndView modelView = new ModelAndView("input_dynamics_costs");
        java.util.List<Product> products = productService.getAll();
        modelView.addObject("productList", products);

        CommandObjectForAdCosts commandObjectForAdCosts = new CommandObjectForAdCosts();

        modelView.addObject("commandObjectForCosts", commandObjectForAdCosts);

        return modelView;
    }

    @InitBinder
    protected void initBinderProduct(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Product.class, new PropertyEditorSupport() {

            public void setAsText(String text) {
                Product product = productService.getProductByName(text);
                this.setValue(product);
            }

            public String getAsText() {
                Product product = (Product) this.getValue();

                if (product!=null)
                {
                    return product.getName();
                }
                else
                {
                    return null;
                }
            }
        });
    }





}
