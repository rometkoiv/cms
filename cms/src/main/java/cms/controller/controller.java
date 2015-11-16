package cms.controller;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cms.backend.dao.EmpUserDAO;
import cms.backend.service.AccountManagerService;
import cms.frontend.MainView;


@Controller
@RequestMapping("/hello")
public class controller {
	String message = "testpage";
	
	@Autowired
	private EmpUserDAO empUserDAO;
    
	@Autowired
	private AccountManagerService accountManager;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showMessage(HttpServletRequest request,HttpSession session) {
		
		Enumeration<String> atb = session.getAttributeNames();
		String s="<hr/><br/><h3>Session:</h3>";
		do {
			String param = (String) atb.nextElement();
			s += "<br/><b>"+param +"</b><hr/><pre>"+ session.getAttribute(param)+"</pre>";
		}
		while(atb.hasMoreElements());
         
		
		
		ServletContext context = request.getSession().getServletContext();
		String r="<hr/><br/><h3>System:</h3>";
		atb = context.getAttributeNames();
		do {
			String param = (String) atb.nextElement();
			r += "<br/><b>"+param +"</b><hr/><pre>"+ context.getAttribute(param)+"</pre>";
			
		}
		while(atb.hasMoreElements());
		//System.out.println(context.getAttribute("org.apache.tomcat.util.scan.MergedWebXml"));
        
		
		
		
		MainView mv = new MainView(accountManager);
		//RequestContextHolder.currentRequestAttributes().getSessionId()
		//mv.addObject("message", ConfReader.getConf("hibernate.connection.username"));
		mv.addObject("config", r);
		mv.addObject("session", s);
		//mv.addObject("name", name);
		
		
		
	    mv.setViewName("hw");
		return mv;
	}
		
}