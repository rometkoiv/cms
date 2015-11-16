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

import cms.backend.model.CommDeviceType;
import cms.backend.service.AccountManagerService;
import cms.backend.service.CommDeviceTypeService;
import cms.frontend.MainView;
import cms.log.cmsLogger;

@Controller
@RequestMapping("/CommDeviceType")
public class CommDeviceTypeController {
	@Autowired
	private AccountManagerService accountManager;
	
	@Autowired
	private CommDeviceTypeService commdevicetypeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getGroups(){
		MainView mv = new MainView(accountManager);
		mv.addObject("commdevicetypeList",commdevicetypeService.getList());
		mv.setViewName("CommDeviceType");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, params="id")
	public ModelAndView getGroup(@RequestParam("id") Long id){
		MainView mv = new MainView(accountManager);
		mv.addObject("commdevicetypeList",commdevicetypeService.getList());
		mv.addObject("commdevicetype",commdevicetypeService.getCommDeviceTypeByID(id));
		mv.setViewName("CommDeviceType");
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.GET, params= { "deleteID" })
	public ModelAndView deleteGroup(@RequestParam("deleteID") Long deleteID){
		MainView mv = new MainView(accountManager);
		if(deleteID !=null  ){
		String res = commdevicetypeService.remove(deleteID);
        if(res.isEmpty()){
        	mv.addObject("info","Eemladatud");
        }else{
        	mv.addObject("error",res);
        }
       
		}
		else{
			mv.addObject("error","Ei leidnud ID");
		}
		
		mv.addObject("commdevicetypeList",commdevicetypeService.getList());
		mv.setViewName("CommDeviceType");
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.GET, params="new")
	public ModelAndView insertGroup(CommDeviceType newCommDeviceType){
		MainView mv = new MainView(accountManager);
		mv.addObject("commdevicetypeList",commdevicetypeService.getList());
		mv.addObject("commdevicetype",newCommDeviceType);
		mv.setViewName("CommDeviceType");
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.POST, params="commDeviceType")
	public ModelAndView updateGroup(@RequestParam("commDeviceType") Long id,  @ModelAttribute("commdevicetype") @Valid final CommDeviceType updatableCommDeviceType, final BindingResult result){
		MainView mv = new MainView(accountManager);
		
		if (result.hasErrors()) { 
			cmsLogger.Log("CommDeviceType valideerimise vead","");
			mv.addObject("commdevicetype",updatableCommDeviceType);
			mv.addObject("error","ei valideeru");
			
		}
		else
		{
		
			mv.addObject("info","Salvestatud");
			mv.addObject("group",commdevicetypeService.update(updatableCommDeviceType,(long) mv.getModel().get("currentEployeeID")));
		}
		
		mv.addObject("commdevicetypeList",commdevicetypeService.getList());
		
		mv.setViewName("CommDeviceType");
		return mv;
	
	}
	
}
