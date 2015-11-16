package cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cms.backend.dao.DaoException;
import cms.backend.dao.EmpUserDAO;
import cms.backend.service.AccountManagerService;
import cms.frontend.MainView;



@Controller
public class loginController {
	@Autowired
	private EmpUserDAO empUserDAO;
	
	@Autowired
	private AccountManagerService accountManager;
    
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,
		@RequestParam(value = "accessDenied", required = false) String accessDenied
			) {
		
	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Vale kasutajanimi vıi parool!");
	  }
 
	  if (logout != null) {
		model.addObject("msg", "Kenasti v‰lja loginud");
	  }
	  
	  if (accessDenied != null) {
			model.addObject("msg", "See leht vajab ligip‰‰su");
		  }
	 
	  try {
		model.addObject("availableUsers",empUserDAO.getUsers());
	} catch (DaoException e) {
		
	}
	  
	  model.setViewName("login");
 
	  return model;
 
	}
    
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		MainView mv = new MainView(accountManager);
		
		mv.setViewName("403");
		return mv;

	}
//404 Lehte pole
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public ModelAndView pageNotExist() {

		MainView mv = new MainView(accountManager);
		mv.setViewName("404");
		return mv;

	}
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		MainView model = new MainView(accountManager);
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is default page!");
		model.setViewName("index");
		return model;

	}
	
	@RequestMapping(value = { "/log" }, method = RequestMethod.GET)
	public ModelAndView logPage() {
		
		MainView model = new MainView(accountManager);
		model.addObject("logfile",cms.utils.File.getLog());
		model.setViewName("log");
		return model;

	}
	
	
	
	
}
