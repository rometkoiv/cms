package cms.frontend;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;

import cms.backend.model.UserWithName;
import cms.backend.service.AccountManagerService;

public class MainView  extends ModelAndView{
  
  public MainView( AccountManagerService accountManagerService){
	   super();
	   
	   UserWithName uname = getUser(accountManagerService);
	   if(uname!=null){
	   addObject("loggedIn",uname);
	   addObject("currentUserName",uname.getUsername());
	   addObject("currentUserID",uname.getEmpUser());
	   addObject("currentEployeeID",uname.getEmployee());
	   }
   }
   
   
   private UserWithName getUser( AccountManagerService accountManagerService){
	   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth!=null) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			    if(userDetail!= null && !userDetail.getUsername().isEmpty() && accountManagerService!=null){
			    	String username = userDetail.getUsername().toString();
			
			     
				 return accountManagerService.viewAccount(username);
			    }
		}
		return null;
   }
}
