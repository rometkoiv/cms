package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import cms.backend.dao.CGroupDAO;
import cms.backend.model.CGroup;
import cms.log.cmsLogger;

@Service("CGroupTransactionalService")
public class CGroupTransactionalServiceImpl implements CGroupTransactionalService
{
	@Autowired
	private CGroupDAO cgroupDAO;
	@Autowired
	private Validator validator;
	
	
	public CGroup getCGroupByID(Long id) {
	
		
		CGroup cgroup = null;
		try {
           cgroup = cgroupDAO.getCGroupByID(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CGroupTransactionalServiceImpl.getCGroupByID():",ex.getMessage());
			
		}

		return cgroup;
	}
    
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public CGroup update(CGroup cgroup, Long upuser) {
	    try {
           return cgroupDAO.update(cgroup,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CGroupTransactionalService.update():",ex.getMessage());
			return null;
		}

		
	}

	public List<CGroup> getList() {
		List<CGroup> cgroups = null;
		try {
			
			cgroups = cgroupDAO.getList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CGroupTransactionalService.getList():",ex.getMessage());
			
		}

		return cgroups;
	}
	
	public List<CGroup> findInUse(Long id) {
		List<CGroup> cgroups = null;
		try {
			
			cgroups = cgroupDAO.findInUse(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CGroupTransactionalService.getList():",ex.getMessage());
			
		}

		return cgroups;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Long id) {
	boolean success = true;
		try {
			
			cgroupDAO.remove(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CGroupTransactionalService.remove("+String.valueOf(id)+"):",ex.getMessage());
			success = false;
		}
		return success;
	}

	
	
}
