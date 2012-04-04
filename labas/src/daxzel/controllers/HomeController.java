package daxzel.controllers;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
 
@Controller
public class HomeController {
 
	@RequestMapping("/")
	public ModelAndView redirectToHome() {
		return new ModelAndView(new RedirectView("/home"));
	}
	
    @RequestMapping("/home")
    public ModelAndView helloWorld() {
 
        return new ModelAndView("home");
    }
}