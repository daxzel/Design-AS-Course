package daxzel.controllers;

import daxzel.model.services.ProductService;
 
import daxzel.model.domains.Product;

import daxzel.model.domains.Group;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.ServletRequestDataBinder;
import java.beans.PropertyEditorSupport;
import org.apache.commons.lang.StringUtils;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


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
    public ModelAndView addProduct(@ModelAttribute("product") @Valid
                            Product product,  BindingResult result)
    {
        if (result.hasErrors()) {
            ModelAndView modelView = new ModelAndView("add_product");
            modelView.addObject("product", product);
            modelView.addObject("add", new Boolean(true));

            return modelView;
        }

        productService.add(product);
        return new ModelAndView("redirect:/products");
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
    
    
    @RequestMapping(value="/{key}/add/",method = RequestMethod.GET)
    public ModelAndView newProductToGroup(@PathVariable("key") Long key) 
    {       
    	
    	Group group = productService.findGroup(key);

    	if (group!=null)
    	{
	    	Product product = new Product();
	    	product.setGroup(group);
	    	ModelAndView modelView = new ModelAndView("add_product");
	    	modelView.addObject("product", product);
	    	modelView.addObject("add", new Boolean(true));
	    	return modelView;
	    }
    	else
    	{
            throw new RuntimeException(key.toString());
    		//return new ModelAndView("redirect:/products");
    	}
    }
    
    @InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Group.class, new PropertyEditorSupport() {

			public void setAsText(String text) {
				if (StringUtils.isNumeric(text))
				{
					Long id  = Long.parseLong(text);
					Group group = productService.findGroup(id);
					this.setValue(group);
				}
				else
				{
					this.setValue(null);
				}			
				
			}
			
			public String getAsText() {
				Group group = (Group) this.getValue();
				if (group!=null)
				{
					return Long.toString(group.getKey());
				}
				else
				{
					return "";
				}
			}
		});
	}
    
    
}