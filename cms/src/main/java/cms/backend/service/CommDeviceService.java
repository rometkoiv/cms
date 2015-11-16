package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import cms.backend.model.CommDevice;
import cms.log.cmsLogger;

@Service("CommDeviceService")
public class CommDeviceService {
	
	@Autowired
	private CommDeviceTransactionalService commdeviceTransactionalService ;
	@Autowired
    private PlatformTransactionManager transactionManager;
	
	public CommDevice getCommDeviceByID(Long id){
		CommDevice commdevice = null;
		try {
			commdevice=commdeviceTransactionalService.getCommDeviceByID(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTransactionalService.getUserByUserName():",ex.getMessage());
		}

		return commdevice;
	}
	public CommDevice update(CommDevice commdevice, int order){
		CommDevice rcommdevice = null;
		try {
            CommDevice ucomm = null;
            
			Long curPos = new Long(0);
			Long lastId = new Long(0);
			List<CommDevice> currentDevices = getList(commdevice.getCustomerBean().getCustomer());
			if(currentDevices !=null && !currentDevices.isEmpty()){
				CommDevice prev = null;
				//System.out.println("Ifis .... "+lastId);	
				boolean nextFlag = false;
				for(CommDevice c : currentDevices){
					//System.out.println("Tsüklis .... "+lastId);
					if(nextFlag){
				       ucomm = c;
					}
					 	if(order ==1 && c.getCommDevice() == commdevice.getCommDevice() && prev!=null){
					 		ucomm = prev;
					 		curPos = commdevice.getOrderb();
					 		ucomm.setOrderb(curPos);
					 		commdevice.setOrderb(curPos-1);
					 		
					 		//System.out.println("Liigutan ülesse .... "+curPos);
					 	}else{
					 		prev = c;
					 	}
					 	if(order ==2 && c.getCommDevice() == commdevice.getCommDevice()){
					 		nextFlag = true;
					 		//System.out.println("Liigutan alla .... "+ curPos);
					 	}else{nextFlag= false;}
					
					
					lastId =c.getCommDevice();
				}
				
				if(ucomm == null && order == 0){
					//System.out.println("Oli null "+ ucomm);
					commdevice.setOrderb(prev.getOrderb()+1);
				}
				if(ucomm != null && order == 2){
					//System.out.println("viimase id on "+lastId);
					if(commdevice.getCommDevice()!= lastId){
					curPos = commdevice.getOrderb();
					ucomm.setOrderb(curPos);
					commdevice.setOrderb(curPos+1);
					}
				}
				
			}
			if(lastId == 0 ){
				//System.out.println("Muudan siit .... "+lastId);
				commdevice.setOrderb(new Long(1));
			}
			
			if(ucomm!=null){
				//System.out.println("muudan vana"+ucomm.getValueText()+ucomm.getOrderb());
				commdeviceTransactionalService.update(ucomm);	
			}
			//System.out.println("mida muudan"+commdevice.getValueText()+commdevice.getOrderb());
			//System.out.println("Tüüp on"+commdevice.getCommDeviceTypeBean().getCommDeviceType());
			rcommdevice=commdeviceTransactionalService.update(commdevice);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTransactionalService.update():",ex.getMessage());
		}

		return rcommdevice;
	}
	public List<CommDevice> getList(Long customer){
		List<CommDevice> commdeviceList = null;
		try {
			commdeviceList=commdeviceTransactionalService.getList(customer);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTransactionalService.getUsers():",ex.getMessage());
		}
		return commdeviceList;
	}
	
	public boolean remove(Long id){
		boolean success = true;
		try {
			success = commdeviceTransactionalService.remove(id);
		}

		catch(Exception ex)
		{
			success=false;
			cmsLogger.Log("CommDeviceTransactionalService.remove():",ex.getMessage());
		}

		return success;
	}
	
}
