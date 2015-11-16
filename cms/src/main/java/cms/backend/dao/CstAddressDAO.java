package cms.backend.dao;

import java.util.List;

import cms.backend.model.CstAddress;

public interface CstAddressDAO {
	
	public CstAddress getCstAddressByID(Long id, Long customer) throws DaoException;
	public CstAddress update(CstAddress cstaddress, Long upuser) throws DaoException;
	public List<CstAddress> getList(Long customer) throws DaoException ;
	boolean remove (Long id) throws DaoException ;
	
}
