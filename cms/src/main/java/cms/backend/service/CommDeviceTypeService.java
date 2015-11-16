package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.backend.model.CommDeviceType;
import cms.log.cmsLogger;

@Service("CommDeviceTypeService")
public class CommDeviceTypeService {
	
	@Autowired
	private CommDeviceTypeTransactionalService commdevicetypeTransactionalService ;
	
	public CommDeviceType getCommDeviceTypeByID(Long id){
		CommDeviceType commdevicetype = null;
		try {
			commdevicetype=commdevicetypeTransactionalService.getCommDeviceTypeByID(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeTransactionalService.getUserByUserName():",ex.getMessage());
		}

		return commdevicetype;
	}
	public CommDeviceType update(CommDeviceType commdevicetype, Long upuser){
		try {
			commdevicetype=commdevicetypeTransactionalService.update(commdevicetype,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeTransactionalService.update():",ex.getMessage());
		}

		return commdevicetype;
	}
	public List<CommDeviceType> getList(){
		List<CommDeviceType> commdevicetypeList = null;
		try {
			commdevicetypeList=commdevicetypeTransactionalService.getList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeTransactionalService.getUsers():",ex.getMessage());
		}
		return commdevicetypeList;
	}
	
	public String remove(Long id){
		boolean success = false;
		String message = "";
		try {
			List<CommDeviceType> inUse = commdevicetypeTransactionalService.findInUse(id);
			if(inUse!= null && !inUse.isEmpty()){
			  message = "Antud tüüp on kasutuses";
			  System.out.println("KAsutuses");
			}
			else{
				System.out.println("vaba");
			success = commdevicetypeTransactionalService.remove(id);
			}
		}

		catch(Exception ex)
		{
			success=false;
			cmsLogger.Log("CommDeviceTypeTransactionalService.remove():",ex.getMessage());
		}
        if(!success && message.isEmpty()){message = "Kustutamine ei õnnestunud";}
		return message;
	}
	
}
