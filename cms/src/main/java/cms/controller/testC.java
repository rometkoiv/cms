package cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class testC {
	String message = "UrlTest";
	
 
	@RequestMapping(value="/test/**",method=RequestMethod.GET) 
	
	public ModelAndView showMessage(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name",(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE) );
		return mv;
	} 
	
}