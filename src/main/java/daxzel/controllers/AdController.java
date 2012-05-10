package daxzel.controllers;

import daxzel.model.domains.Ad;
import daxzel.model.domains.KindAd;
import daxzel.model.domains.Product;
import daxzel.model.domains.Production;
import daxzel.model.services.AdService;
import daxzel.model.services.KindAdService;
import daxzel.model.services.ProductService;
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
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/ads")
public class AdController {

    @Autowired
    private AdService adService;

    @Autowired
    private KindAdService adKindService;

    @Autowired
    private ProductService productService;


    @RequestMapping("/delete/{id}")
    public String deleteAd(@PathVariable("id")
                                   Long id)
    {
        adService.remove(id);
        return "redirect:/ads";
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addAd(@ModelAttribute("ad")
                            Ad ad, BindingResult result)
    {
        adService.add(ad);
        return "redirect:/ads";
    }

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView showAd()
    {
        return new ModelAndView("ads","adList", adService.getAll());
    }

    @RequestMapping(value="/add", method= RequestMethod.GET)
    public ModelAndView newAd()
    {
        Ad ad = new Ad();
        ModelAndView modelView = new ModelAndView("add_ad");
        modelView.addObject("ad", ad);
        modelView.addObject("add", new Boolean(true));
        java.util.List<KindAd> kindes = adKindService.getAll();
        modelView.addObject("kindAdList", kindes);
        java.util.List<Product> products = productService.getAll();
        modelView.addObject("productList", products);
        return modelView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView updateAd(@PathVariable("id") Long id)
    {
        Ad ad = adService.getByID(id);
        ModelAndView modelView = new ModelAndView("add_ad");
        modelView.addObject("ad", ad);
        modelView.addObject("add", new Boolean(false));
        java.util.List<KindAd> kindes = adKindService.getAll();
        modelView.addObject("kindAdList", kindes);
        java.util.List<Product> products = productService.getAll();
        modelView.addObject("productList", products);
        return modelView;
    }

    @InitBinder
    protected void initBinderKindAd(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(KindAd.class, new PropertyEditorSupport() {

            public void setAsText(String text) {
                KindAd kind = adKindService.getKindAdByName(text);
                this.setValue(kind);
            }

            public String getAsText() {
                KindAd kind = (KindAd) this.getValue();

                if (kind!=null)
                {
                    return kind.getName();
                }
                else
                {
                    return null;
                }
            }
        });
    }

    @InitBinder
    protected void initBinderProduct(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(KindAd.class, new PropertyEditorSupport() {

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
