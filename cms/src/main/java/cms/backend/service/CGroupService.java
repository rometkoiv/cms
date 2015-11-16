package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.backend.model.CGroup;
import cms.log.cmsLogger;

@Service("CGroupService")
public class CGroupService {
	
	@Autowired
	private CGroupTransactionalService cgroupTransactionalService ;
	
	public CGroup getCGroupByID(Long id){
		CGroup cgroup = null;
		try {
			cgroup=cgroupTransactionalService.getCGroupByID(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CGroupTransactionalService.getUserByUserName():",ex.getMessage());
		}

		return cgroup;
	}
	public CGroup update(CGroup cgroup, Long upuser){
		try {
			cgroup=cgroupTransactionalService.update(cgroup,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CGroupTransactionalService.update():",ex.getMessage());
		}

		return cgroup;
	}
	public List<CGroup> getList(){
		List<CGroup> cgroupList = null;
		try {
			cgroupList=cgroupTransactionalService.getList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CGroupTransactionalService.getUsers():",ex.getMessage());
		}
		return cgroupList;
	}
	
	public String remove(Long id){
		boolean success = false;
		String message = "";
		try {
			List<CGroup> inUse = cgroupTransactionalService.findInUse(id);
			if(inUse!= null && !inUse.isEmpty()){
			  message = "Antud tüüp on kasutuses";
			  
			}
			else{
				
			success = cgroupTransactionalService.remove(id);
			}
		}

		catch(Exception ex)
		{
			success=false;
			cmsLogger.Log("CGroupTransactionalService.remove():",ex.getMessage());
		}
        if(!success && message.isEmpty()){message = "Kustutamine ei õnnestunud";}
		return message;
	}
	
}
