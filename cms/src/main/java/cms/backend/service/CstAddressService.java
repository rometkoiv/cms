package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import cms.backend.model.CstAddress;
import cms.log.cmsLogger;

@Service("CstAddressService")
public class CstAddressService {

	@Autowired
	private CstAddressTransactionalService cstaddressTransactionalService;
	@Autowired
	private PlatformTransactionManager transactionManager;

	public CstAddress getCstAddressByID(Long id, Long customer) {
		CstAddress cstaddress = null;
		try {
			cstaddress = cstaddressTransactionalService.getCstAddressByID(id,
					customer);
		}

		catch (Exception ex) {
			cmsLogger.Log(
					"CstAddressTransactionalService.getUserByUserName():",
					ex.getMessage());
		}

		return cstaddress;
	}

	public CstAddress update(CstAddress cstaddress, Long upuser) {
		CstAddress rcstaddress = null;
		try {

			// Tee peamiseks
			if (cstaddress.getAddressType() == null) {
				cstaddress.setAddressType(new Long(2));
			}

			CstAddress currentActive = cstaddressTransactionalService
					.getCstAddressByID(null, cstaddress.getCustomerBean()
							.getCustomer());

			if (currentActive != null
					&& cstaddress.getAddressType() != null
					&& cstaddress.getAddressType() == 1
					&& currentActive.getCstAddress() != cstaddress
							.getCstAddress()) {

				currentActive.setAddressType(new Long(2));
				currentActive = cstaddressTransactionalService.update(
						currentActive, upuser);
				
			}

			if (currentActive == null) {
				cstaddress.setAddressType(new Long(1));
			}

			// Ja nüüd uuendame
			rcstaddress = cstaddressTransactionalService.update(cstaddress,	upuser);
			currentActive = cstaddressTransactionalService.getCstAddressByID(null, cstaddress.getCustomerBean().getCustomer());
			//Ja kui kasutaja tegi eva paneme ikkagi aktiivseks
			if(currentActive == null){
				rcstaddress.setAddressType(new Long(1));
				rcstaddress = cstaddressTransactionalService.update(rcstaddress,	upuser);
			}
		}

		catch (Exception ex) {
			cmsLogger.Log("CstAddressTransactionalService.update():",
					ex.getMessage());
		}

		return rcstaddress;
	}

	public List<CstAddress> getList(Long customer) {
		List<CstAddress> cstaddressList = null;
		try {
			cstaddressList = cstaddressTransactionalService.getList(customer);
		}

		catch (Exception ex) {
			cmsLogger.Log("CstAddressTransactionalService.getUsers():",
					ex.getMessage());
		}
		return cstaddressList;
	}

	public boolean remove(Long id) {
		boolean success = true;
		try {
			success = cstaddressTransactionalService.remove(id);
		}

		catch (Exception ex) {
			success = false;
			cmsLogger.Log("CstAddressTransactionalService.remove():",
					ex.getMessage());
		}

		return success;
	}

}
