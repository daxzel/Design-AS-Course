package daxzel.controllers;

import daxzel.model.services.ProductService;
 
import daxzel.model.domains.Product;

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
@RequestMapping("/products")
public class ProductController {
 	
	@Autowired
 	private ProductService productService;
	
	
	@RequestMapping("/delete/{NCP}")
    public String deleteProduct(@PathVariable("NCP")
    			Long NCP) 
    {       
		productService.removeProductByNCP(NCP);
    	return "redirect:/products";
    }
	
    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product")
                            Product product, BindingResult result) 
    {       
    	productService.add(product);
    	return "redirect:/products";
    }
 
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView showProducts() 
    {
    	return new ModelAndView("products","groupList", productService.getAllGroups());
    }
    
    @RequestMapping(value="/{NCP}", method=RequestMethod.GET)
    public ModelAndView getByNCP(@PathVariable("NCP") Long NCP)  
    {
    	Product product = productService.findProductByNCP(NCP);
        return new ModelAndView("product", "findedProduct", product);
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView newProduct()  
    {
    	Product product = new Product();
    	ModelAndView modelView = new ModelAndView("add_product");
    	modelView.addObject("product", product);
    	modelView.addObject("add", new Boolean(true));
        return modelView;
    }
    
    @RequestMapping(value="/edit/{NCP}", method=RequestMethod.GET)
    public ModelAndView updateProduct(@PathVariable("NCP") Long NCP)  
    {
    	Product product = productService.findProductByNCP(NCP);
    	ModelAndView modelView = new ModelAndView("add_product");
    	modelView.addObject("product", product);
    	modelView.addObject("add", new Boolean(true));
        return modelView;
    }
    
}