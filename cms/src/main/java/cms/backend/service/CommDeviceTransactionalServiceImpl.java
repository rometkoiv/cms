package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import cms.backend.dao.CommDeviceDAO;
import cms.backend.model.CommDevice;
import cms.log.cmsLogger;

@Service("CommDeviceTransactionalService")
public class CommDeviceTransactionalServiceImpl implements CommDeviceTransactionalService
{
	@Autowired
	private CommDeviceDAO commdeviceDAO;
	@Autowired
	private Validator validator;
	
	
	public CommDevice getCommDeviceByID(Long id) {
	
		
		CommDevice commdevice = null;
		try {
           commdevice = commdeviceDAO.getCommDeviceByID(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTransactionalServiceImpl.getCommDeviceByID():",ex.getMessage());
			
			
		}

		return commdevice;
	}
    //,isolation = Isolation.DEFAULT
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public CommDevice update(CommDevice commdevice) {
	    try {
	       
           return commdeviceDAO.update(commdevice);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTransactionalService.update():",ex.getMessage());
			return null;
		}

		
	}

	public List<CommDevice> getList(Long customer) {
		List<CommDevice> commdevices = null;
		try {
			
			commdevices = commdeviceDAO.getList(customer);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTransactionalService.getList():",ex.getMessage());
			
		}

		return commdevices;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Long id) {
	boolean success = true;
		try {
			
			commdeviceDAO.remove(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTransactionalService.remove("+String.valueOf(id)+"):",ex.getMessage());
			success = false;
		}
		return success;
	}

	
	
}
