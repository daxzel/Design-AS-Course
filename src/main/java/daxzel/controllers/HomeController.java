package daxzel.controllers;
 
import daxzel.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
 
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

	@RequestMapping("/")
	public ModelAndView redirectToHome() {
		return new ModelAndView(new RedirectView("/home"));
	}
	
    @RequestMapping("/home")
    public ModelAndView helloWorld() {

        return new ModelAndView("home");

    }
}