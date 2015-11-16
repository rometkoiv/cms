package cms.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cms.backend.dao.ClientSearchDAO;
import cms.backend.dao.DistinctSearchDAO;
import cms.backend.model.ClientSearch;
import cms.backend.service.AccountManagerService;
import cms.frontend.MainView;
import cms.log.cmsLogger;

@Controller
@RequestMapping("/Search")
public class SearchController {
	
	@Autowired
	private AccountManagerService accountManager;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView searchClients(HttpSession session,@RequestParam(value = "orderby", required = false) String orderby){
		MainView mv = new MainView(accountManager);
		ClientSearch cs = (ClientSearch)session.getAttribute("LastSearch");
		boolean doSearch = true; 
		if(cs== null){
			cs = new ClientSearch();
			doSearch = false;
		}
		if(doSearch){
		String sortorder = (String)session.getAttribute("sortorder");
		
		String lastOrderBy = (String)session.getAttribute("lastOrderBy");
		
		if(sortorder == null || sortorder.isEmpty()){
			sortorder = "ASC";
		}else{
			
			if(sortorder.equals("ASC")  && lastOrderBy!= null && orderby != null && orderby.equals(lastOrderBy)){sortorder = "DESC";}
			else{sortorder = "ASC";}
		}
		
		session.setAttribute("sortorder", sortorder);
		session.setAttribute("lastOrderBy", orderby);
		cs.setOrderby(orderby);
		cs.setSort(sortorder);
		
		
		
		ClientSearchDAO csd = new ClientSearchDAO();
		mv.addObject("searchList",csd.searchClients(cs));
		}
		DistinctSearchDAO dsc = new DistinctSearchDAO();
		
		
		
		mv.addObject("searchClient",cs);
		
		mv.addObject("distinctEmployees",dsc.distinctEmployees());
		dsc = new DistinctSearchDAO();
		mv.addObject("distinctGroups",dsc.distinctGroups());
		
		mv.setViewName("search");
		return mv;
	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView performSearch(@ModelAttribute("searchClient") @Valid ClientSearch cs,final BindingResult result,@RequestParam(value = "reset", required = false) String resetF
			,HttpSession session,@RequestParam(value = "orderby", required = false) String orderby){
		MainView mv = new MainView(accountManager);
		boolean doSearch = true; 
		if (result.hasErrors()) { 
			cmsLogger.Log("SearchClient valideerimise vead",result.getAllErrors().toString());
			mv.addObject("error","ei valideeru");
			
			
		}
		else{
			if(resetF!= null && !resetF.isEmpty()){
				cs = (ClientSearch)session.getAttribute("LastSearch");
				if(cs!= null){
					session.removeAttribute("LastSearch");
					session.removeAttribute("sortorder");
					
				}
				cs = new ClientSearch();
				doSearch = false;
			}
		}
		
		if(doSearch){
			
			String lastOrderBy = (String)session.getAttribute("lastOrderBy");
			
			String sortorder = (String)session.getAttribute("sortorder");
			if(sortorder== null || sortorder.isEmpty()){
				sortorder = "ASC";
			}else{
				if(sortorder.equals("ASC") && lastOrderBy!= null  && orderby != null  && orderby.equals(lastOrderBy)){sortorder = "DESC";}
				else{sortorder = "ASC";}
			}
			
			session.setAttribute("sortorder", sortorder);
			session.setAttribute("lastOrderBy", orderby);
			
			cs.setOrderby(orderby);
			cs.setSort(sortorder);
			
		ClientSearchDAO csd = new ClientSearchDAO();
		mv.addObject("searchList",csd.searchClients(cs));
		}
		DistinctSearchDAO dsc = new DistinctSearchDAO();
		//System.out.println(cs.getStrict());
		
		
		
		mv.addObject("searchClient",cs);
		
		mv.addObject("distinctEmployees",dsc.distinctEmployees());
		dsc = new DistinctSearchDAO();
		mv.addObject("distinctGroups",dsc.distinctGroups());
	
		
		session.setAttribute("LastSearch", cs);
		
		mv.setViewName("search");
		return mv;
		
	}
	
}
