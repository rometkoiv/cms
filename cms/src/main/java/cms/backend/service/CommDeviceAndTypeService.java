package cms.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import cms.backend.model.CommDevAndType;
import cms.backend.model.CommDevice;
import cms.backend.model.CommDeviceType;
import cms.log.cmsLogger;

@Service("CommDeviceAndTypeService")
public class CommDeviceAndTypeService {
	
	@Autowired
	private CommDeviceService commdeviceService ;
	@Autowired
	private CommDeviceTypeTransactionalService commdeviceTypeTransactionalService ;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
    private PlatformTransactionManager transactionManager;
	
	private CommDevAndType joinBoth(CommDevice commdev, CommDeviceType commdevicetype){
		 
		CommDevAndType commdevandtype = new CommDevAndType();
		 if(commdev!=null){
		   commdevandtype.setCommDevice(commdev.getCommDevice());
		   commdevandtype.setValueText(commdev.getValueText());
		   commdevandtype.setOrderb(commdev.getOrderb());
		 }
		 if(commdevicetype!=null){
			 commdevandtype.setCommDeviceType(commdevicetype.getCommDeviceType());
			 commdevandtype.setTypeName(commdevicetype.getName());
			 commdevandtype.setTypeDescription(commdevicetype.getDescription());
		 }
	     return commdevandtype;
	 }
	 
	
	public List<CommDevAndType> getList(Long customer){
		List<CommDevice> commdeviceList = null;
		List<CommDevAndType> retList = new ArrayList<CommDevAndType>();
		try {
			commdeviceList=commdeviceService.getList(customer);
			for(CommDevice c : commdeviceList){
	    		 retList.add(joinBoth(c,c.getCommDeviceTypeBean()));
	    	 }
			
		}

		catch(Exception ex)
		{
			retList = null;
			cmsLogger.Log("CommDevAndType.getList():",ex.getMessage());
		}
		return retList;
	}
	
	public CommDevAndType update(CommDevAndType commdevandtype,Long customer, int order ){
		CommDevice commdevice = new CommDevice();
		if(commdevandtype.getCommDevice()!=null){
                commdevice.setCommDevice(commdevandtype.getCommDevice());
		}
		CommDeviceType commdevtype = commdeviceTypeTransactionalService.getCommDeviceTypeByID(commdevandtype.getCommDeviceType());
		
		commdevice.setCommDeviceTypeBean(commdevtype);
		commdevice.setCustomerBean(customerService.getCustomerByID(customer));
    	commdevice.setValueText(commdevandtype.getValueText());
    	commdevice.setOrderb(commdevandtype.getOrderb());
    	commdevice = commdeviceService.update(commdevice, order);
    	return joinBoth(commdevice,commdevtype);
     }
	
	public CommDevAndType getCommDeviceByID(Long id){
		CommDevice commdevice = null;
		CommDevAndType commdeviceandtype;
		try {
			commdevice=commdeviceService.getCommDeviceByID(id);
			commdeviceandtype = joinBoth(commdevice, commdevice.getCommDeviceTypeBean());
		}

		catch(Exception ex)
		{
			commdeviceandtype = null;
			cmsLogger.Log("CommDevAndType.getCommDeviceByID():",ex.getMessage());
		}

		return commdeviceandtype;
	}
	
}
