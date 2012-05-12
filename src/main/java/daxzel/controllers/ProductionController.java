package daxzel.controllers;

import daxzel.model.domains.Product;
import daxzel.model.domains.Production;
import daxzel.model.services.ProductService;
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
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/production")
public class ProductionController {

    @Autowired
    private ProductionService productionService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/delete/{id}")
    public String deleteProduction(@PathVariable("id")
                             Long id)
    {
        productionService.remove(id);
        return "redirect:/production";
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addProduction(@ModelAttribute("production")
                            Production production, BindingResult result)
    {
        productionService.add(production);
        return "redirect:/production";
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
        java.util.List<Product> products = productService.getAll();
        modelView.addObject("productList", products);
        return modelView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView updateProduction(@PathVariable("id") Long id)
    {
        Production production = productionService.getByID(id);
        ModelAndView modelView = new ModelAndView("add_production");
        modelView.addObject("production", production);
        modelView.addObject("add", new Boolean(false));
        java.util.List<Product> products = productService.getAll();
        modelView.addObject("productList", products);
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
