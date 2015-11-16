package cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;







import cms.backend.model.UserWithName;
import cms.backend.service.AccountManagerService;
//import cms.backend.service.EmpUserService;
//import cms.backend.service.EmployeeService;
import cms.frontend.MainView;
import cms.log.cmsLogger;

@Controller
@RequestMapping("/empUser")
public class empUserController {
	//@Autowired
	//private EmpUserService empUserService;
	
	//@Autowired
	//private EmployeeService employeeService;
	@Autowired
	private AccountManagerService accountManager;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getEmpUsers(){
		MainView mv = new MainView(accountManager);
		mv.addObject("userWithNames",accountManager.getAccountList());
		mv.setViewName("empuser");
		return mv;
	
	}
	@RequestMapping(method = RequestMethod.GET, params="userName")
	public ModelAndView getEmpUser(@RequestParam("userName") String username){
		MainView mv = new MainView(accountManager);
		mv.addObject("userWithNames",accountManager.getAccountList());
		mv.addObject("userWithName",accountManager.viewAccount(username));
		mv.setViewName("empuser");
		return mv;
	
	}
	
	
	@RequestMapping(method = RequestMethod.GET, params= { "DeleteUserName" })
	public ModelAndView deleteEmpUser(@RequestParam("DeleteUserName") String deleteUserName){
		MainView mv = new MainView(accountManager);
		if(deleteUserName !=null && !deleteUserName.equals(mv.getModel().get("currentUserName").toString()) ){
        if(accountManager.remove(deleteUserName)){
        	mv.addObject("info","Eemladatud: "+deleteUserName);
        }else{
        	mv.addObject("error","Ei saanud kustutada");
        }
		
		
		}
		else{
			mv.addObject("error","Sisselogitud kasutajat ei saa kustutada");
		}
		mv.addObject("userWithNames",accountManager.getAccountList());
		mv.setViewName("empuser");
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.GET, params="new")
	public ModelAndView insertEmpUser(UserWithName newUser){
		MainView mv = new MainView(accountManager);
		mv.addObject("userWithNames",accountManager.getAccountList());
		mv.addObject("userWithName",newUser);
		
		mv.setViewName("empuser");
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.POST, params="empUser")
	public ModelAndView updateEmpUser(@RequestParam("empUser") Long empUser,  @ModelAttribute("userWithName") @Valid final UserWithName updatableEmpUser, final BindingResult result){
		MainView mv = new MainView(accountManager);
		
		if (result.hasErrors()) { 
			cmsLogger.Log("userWithName valideerimise vead","");
			mv.addObject("userWithName",updatableEmpUser);
			mv.addObject("error","ei valideeru");
			
		}
		else
		{
		
			mv.addObject("info","Salvestatud");
			mv.addObject("userWithName",accountManager.SaveAccount(updatableEmpUser,(long) mv.getModel().get("currentEployeeID")));
		}
		
		mv.addObject("userWithNames",accountManager.getAccountList());
		
		mv.setViewName("empuser");
		return mv;
	
	}
}
