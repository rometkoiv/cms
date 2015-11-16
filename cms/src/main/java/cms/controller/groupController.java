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

import cms.backend.model.CGroup;
import cms.backend.service.AccountManagerService;
import cms.backend.service.CGroupService;
import cms.frontend.MainView;
import cms.log.cmsLogger;

@Controller
@RequestMapping("/groupManager")
public class groupController {
	@Autowired
	private AccountManagerService accountManager;
	
	@Autowired
	private CGroupService cgroupService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getGroups(){
		MainView mv = new MainView(accountManager);
		mv.addObject("groupList",cgroupService.getList());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, params="id")
	public ModelAndView getGroup(@RequestParam("id") Long id){
		MainView mv = new MainView(accountManager);
		mv.addObject("groupList",cgroupService.getList());
		mv.addObject("group",cgroupService.getCGroupByID(id));
		mv.setViewName("groupManager");
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.GET, params= { "deleteID" })
	public ModelAndView deleteGroup(@RequestParam("deleteID") Long deleteID){
		MainView mv = new MainView(accountManager);
		if(deleteID !=null  ){
		String res = cgroupService.remove(deleteID);
        if(res.isEmpty()){
        	mv.addObject("info","Eemladatud");
        }else{
        	mv.addObject("error",res);
        }
       
		}
		else{
			mv.addObject("error","Ei leidnud ID");
		}
		
		mv.addObject("groupList",cgroupService.getList());
		mv.setViewName("groupManager");
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.GET, params="new")
	public ModelAndView insertGroup(CGroup newCGroup){
		MainView mv = new MainView(accountManager);
		mv.addObject("groupList",cgroupService.getList());
		mv.addObject("group",newCGroup);
		mv.setViewName("groupManager");
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.POST, params="cGroup")
	public ModelAndView updateGroup(@RequestParam("cGroup") Long id,  @ModelAttribute("group") @Valid final CGroup updatableCGroup, final BindingResult result){
		MainView mv = new MainView(accountManager);
		
		if (result.hasErrors()) { 
			cmsLogger.Log("CGroup valideerimise vead","");
			mv.addObject("group",updatableCGroup);
			mv.addObject("error","ei valideeru");
			
		}
		else
		{
		
			mv.addObject("info","Salvestatud");
			mv.addObject("group",cgroupService.update(updatableCGroup,(long) mv.getModel().get("currentEployeeID")));
		}
		
		mv.addObject("groupList",cgroupService.getList());
		
		mv.setViewName("groupManager");
		return mv;
	
	}
	
}
