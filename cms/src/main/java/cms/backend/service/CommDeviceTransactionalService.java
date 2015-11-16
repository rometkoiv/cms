package cms.backend.service;

import java.util.List;

import cms.backend.model.CommDevice;


public interface CommDeviceTransactionalService {
	public CommDevice getCommDeviceByID(Long id);
	public CommDevice update(CommDevice commdevice);
	public List<CommDevice> getList(Long customer);
	boolean remove (Long id);
	
}
