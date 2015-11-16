package cms.backend.service;

import java.util.List;

import cms.backend.model.CstAddress;


public interface CstAddressTransactionalService {
	public CstAddress getCstAddressByID(Long id, Long customer);
	public CstAddress update(CstAddress cstaddress, Long upuser);
	public List<CstAddress> getList(Long customer);
	boolean remove (Long id);
	
}
