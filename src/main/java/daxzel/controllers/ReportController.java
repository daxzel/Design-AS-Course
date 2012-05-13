package daxzel.controllers;

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
        modelView.addObject("product", null);

        CommandProductHelper commandProductHelper = new CommandProductHelper();

        modelView.addObject("productHelper", commandProductHelper);

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
