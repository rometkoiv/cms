package cms.backend.service;

import java.util.List;

import cms.backend.model.CommDeviceType;


public interface CommDeviceTypeTransactionalService {
	public CommDeviceType getCommDeviceTypeByID(Long id);
	public CommDeviceType update(CommDeviceType commdevicetype, Long upuser);
	public List<CommDeviceType> getList();
	public List<CommDeviceType> findInUse(Long id);
	boolean remove (Long id);
	
}
