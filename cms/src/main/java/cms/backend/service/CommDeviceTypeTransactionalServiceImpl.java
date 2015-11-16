package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import cms.backend.dao.CommDeviceTypeDAO;
import cms.backend.model.CommDeviceType;
import cms.log.cmsLogger;

@Service("CommDeviceTypeTransactionalService")
public class CommDeviceTypeTransactionalServiceImpl implements CommDeviceTypeTransactionalService
{
	@Autowired
	private CommDeviceTypeDAO commdevicetypeDAO;
	@Autowired
	private Validator validator;
	
	public CommDeviceType getCommDeviceTypeByID(Long id) {
	
		
		CommDeviceType commdevicetype = null;
		try {
           commdevicetype = commdevicetypeDAO.getCommDeviceTypeByID(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeTransactionalServiceImpl.getCommDeviceTypeByID():",ex.getMessage());
			
		}

		return commdevicetype;
	}
    
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public CommDeviceType update(CommDeviceType commdevicetype, Long upuser) {
	    try {
           return commdevicetypeDAO.update(commdevicetype,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeTransactionalService.update():",ex.getMessage());
			return null;
		}

		
	}
	public List<CommDeviceType> findInUse(Long id){
		List<CommDeviceType> commdevicetypes = null;
		try {
			
			commdevicetypes = commdevicetypeDAO.findInUse(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeTransactionalService.getList():",ex.getMessage());
			
		}

		return commdevicetypes;
	}
	
	public List<CommDeviceType> getList() {
		List<CommDeviceType> commdevicetypes = null;
		try {
			
			commdevicetypes = commdevicetypeDAO.getList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeTransactionalService.getList():",ex.getMessage());
			
		}

		return commdevicetypes;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Long id) {
	boolean success = true;
		try {
			
			commdevicetypeDAO.remove(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeTransactionalService.remove("+String.valueOf(id)+"):",ex.getMessage());
			success = false;
		}
		return success;
	}

	
	
}
