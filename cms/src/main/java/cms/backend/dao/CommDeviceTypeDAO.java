package cms.backend.dao;

import java.util.List;

import cms.backend.model.CommDeviceType;

public interface CommDeviceTypeDAO {
	public CommDeviceType getCommDeviceTypeByID(Long id) throws DaoException;
	public CommDeviceType update(CommDeviceType commdevicetype, Long upuser) throws DaoException;
	public List<CommDeviceType> findInUse(Long id) throws DaoException;
	public List<CommDeviceType> getList() throws DaoException ;
	boolean remove (Long id) throws DaoException ;
	
}
