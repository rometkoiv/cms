package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import cms.backend.dao.CstAddressDAO;
import cms.backend.model.CstAddress;
import cms.log.cmsLogger;

@Service("CstAddressTransactionalService")
public class CstAddressTransactionalServiceImpl implements CstAddressTransactionalService
{
	@Autowired
	private CstAddressDAO cstaddressDAO;
	@Autowired
	private Validator validator;
	
	
	public CstAddress getCstAddressByID(Long id, Long customer) {
	
		
		CstAddress cstaddress = null;
		try {
           cstaddress = cstaddressDAO.getCstAddressByID(id,customer);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CstAddressTransactionalServiceImpl.getCstAddressByID():",ex.getMessage());
			
			
		}

		return cstaddress;
	}
    //,isolation = Isolation.DEFAULT
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public CstAddress update(CstAddress cstaddress, Long upuser) {
	    try {
	       
           return cstaddressDAO.update(cstaddress,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CstAddressTransactionalService.update():",ex.getMessage());
			return null;
		}

		
	}

	public List<CstAddress> getList(Long customer) {
		List<CstAddress> cstaddresss = null;
		try {
			
			cstaddresss = cstaddressDAO.getList(customer);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CstAddressTransactionalService.getList():",ex.getMessage());
			
		}

		return cstaddresss;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Long id) {
	boolean success = true;
		try {
			
			cstaddressDAO.remove(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CstAddressTransactionalService.remove("+String.valueOf(id)+"):",ex.getMessage());
			success = false;
		}
		return success;
	}

	
	
}
