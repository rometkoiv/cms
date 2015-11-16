package cms.backend.dao;

import java.util.List;

import cms.backend.model.CommDevice;

public interface CommDeviceDAO {
	
	public CommDevice getCommDeviceByID(Long id) throws DaoException;
	public CommDevice update(CommDevice commdevice) throws DaoException;
	public List<CommDevice> getList(Long customer) throws DaoException ;
	boolean remove (Long id) throws DaoException ;
	
}
