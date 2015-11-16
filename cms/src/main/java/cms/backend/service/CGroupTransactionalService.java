package cms.backend.service;

import java.util.List;

import cms.backend.model.CGroup;


public interface CGroupTransactionalService {
	public CGroup getCGroupByID(Long id);
	public CGroup update(CGroup cgroup, Long upuser);
	public List<CGroup> getList();
	public List<CGroup> findInUse(Long id);
	boolean remove (Long id);
	
}
