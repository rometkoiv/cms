package cms.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleCustomException(Exception ex) {
		ModelAndView model = new ModelAndView("error");
		model.setViewName("error");
		model.addObject("error",ex.getMessage());
		model.addObject("message", ex.getStackTrace());
		return model;

	}
}
