package cms.backend.dao;

import java.util.List;

import cms.backend.model.CGroup;

public interface CGroupDAO {
	public CGroup getCGroupByID(Long id) throws DaoException;
	public CGroup update(CGroup cgroup, Long upuser) throws DaoException;
	public List<CGroup> getList() throws DaoException ;
	public List<CGroup> findInUse(Long id) throws DaoException ;
	boolean remove (Long id) throws DaoException ;
	
}
