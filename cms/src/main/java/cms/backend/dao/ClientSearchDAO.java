package cms.backend.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cms.backend.db.dbConnection;
import cms.backend.model.ClientSearch;
import cms.log.cmsLogger;

public class ClientSearchDAO {
	private String sql;
	private Connection db;
	
	public ClientSearchDAO()
	  {
		super();
	    try
	    {
	       this.db = dbConnection.getConnection();
	    }
	    catch (Exception ex)
	    {
	    	 cmsLogger.Log("ClientSearchDAO:Opening DB:", ex.getMessage());
	    }
	  }
	  
	public List<ClientSearch> searchClients(ClientSearch cs)
	  {
		Statement newStatement = null;
		ResultSet localResultSet = null;
		List<ClientSearch> returnList = new ArrayList<ClientSearch>();
	    adjustAddressType(cs);
	    adjustCommDevice(cs);
	      this.sql = searchString +" " +addConditions(cs) +" " +addOrder(cs);
	      if(cs.isLogsql()){
	      cmsLogger.Log("SQL päring:",this.sql);
	      }
	    
	    try
	    {
	    	newStatement = db.createStatement();
	    	localResultSet = newStatement.executeQuery(this.sql);
	      
	      if(localResultSet!=null){
	      while (localResultSet.next())
	      {
	      ClientSearch rcs = new ClientSearch();
	        rcs.setCustomer(localResultSet.getLong("customer"));
	        rcs.setFirstName(localResultSet.getString("firstName"));
	        rcs.setLastName(localResultSet.getString("lastName"));
	        rcs.setIdentityCode(localResultSet.getString("identityCode"));
	        rcs.setNote(localResultSet.getString("note"));
	        rcs.setBirthDate(localResultSet.getTimestamp("birthDate"));
	        rcs.setCreated(localResultSet.getTimestamp("created"));
	        rcs.setUpdated(localResultSet.getTimestamp("updated"));
	        rcs.setUpdatedByName(localResultSet.getString("updatedBy"));
	        rcs.setCreatedByName(localResultSet.getString("createdBy"));
	        
	        
	        rcs.setCgName(localResultSet.getString("cgName"));
	        
	        rcs.setCstAddress(localResultSet.getLong("cstAdress"));
	        rcs.setAddress(localResultSet.getString("address"));
	        rcs.setAddressType(localResultSet.getLong("addressType"));
	        rcs.setHouse(localResultSet.getString("house"));
	        rcs.setTownCounty(localResultSet.getString("townCounty"));
	        rcs.setCounty(localResultSet.getString("county"));
	        rcs.setZip(localResultSet.getString("zip"));
	        
	        rcs.setCommDeviceType(localResultSet.getLong("commDeviceType"));
	        rcs.setCommDevTypeName(localResultSet.getString("commDeviceTypeName"));
	        
	        rcs.setCommDev(localResultSet.getLong("commDev"));
	        rcs.setCommDevName(localResultSet.getString("commDevName"));
	        
	        returnList.add(rcs);
	        
	        
	      }
	      }
	    }
	    catch (Exception ex)
	    {
	      cmsLogger.Log("cms.backend.dao.clientSearchDAO.searchClients():", ex.toString());
	    }
	    finally
	    {
	      dbConnection.closeStatement(newStatement);
	      dbConnection.closeResultSet(localResultSet);
	    }
	    DAOClose();
	    return returnList;
	  }
	public void DAOClose()
	  {
	    try
	    {
	       dbConnection.close(this.db);
	    }
	    catch (Exception ex)
	    {
	    	 cmsLogger.Log("cms.backend.dao.clientSearchDAO:Closing DB:" , ex.getMessage());
	    }
	  }
	
	private void adjustAddressType(ClientSearch cs){
		if(sFilled(cs.getAddress()) || sFilled(cs.getHouse()) || sFilled(cs.getTownCounty()) || sFilled(cs.getAddress()) || sFilled(cs.getCounty()) || sFilled(cs.getZip()))
		{
			this.searchString = this.searchString.replace("{address_type}", "");
		}
		else{
			this.searchString = this.searchString.replace("{address_type}", " and adr.address_type = 1");
		}
	}
	
	private void adjustCommDevice(ClientSearch cs){
		if(sFilled(cs.getCommDevName()))
		{
			this.searchString = this.searchString.replace("{comm_device}", "");
		}
		else{
			this.searchString = this.searchString.replace("{comm_device}", "  and comm.orderb = (select min(orderb) from comm_device dev where dev.customer = cu.customer)");
		}
	}
	
	private String addConditions(ClientSearch cs){
		String ret = "where cu.customer is not null";
		if(sFilled(cs.getFirstName()))
		{
			ret += strictString("cu.first_name",cs.getFirstName(),cs.getStrict());
		}
		if(sFilled(cs.getLastName()))
		{
			ret += strictString("cu.last_name",cs.getLastName(),cs.getStrict());
		}
		
		if(sFilled(cs.getIdentityCode()))
		{
			ret += strictString("cu.identity_code",cs.getIdentityCode(),cs.getStrict());
		}
		
		if(sFilled(cs.getNote()))
		{
			ret += strictString("cu.note",cs.getNote(),cs.getStrict());
		}
		
		if(sFilled(cs.getAddress()))
		{
			ret += strictString("adr.address",cs.getAddress(),cs.getStrict());
		}
		
		if(sFilled(cs.getHouse()))
		{
			ret += strictString("adr.house",cs.getHouse(),cs.getStrict());
		}
		
		if(sFilled(cs.getTownCounty()))
		{
			ret += strictString("adr.town_county",cs.getTownCounty(),cs.getStrict());
		}
		
		if(sFilled(cs.getCounty()))
		{
			ret += strictString("adr.county",cs.getCounty(),cs.getStrict());
		}
		
		if(sFilled(cs.getZip()))
		{
			ret += strictString("adr.zip",cs.getZip(),cs.getStrict());
		}
		
		if(cs.getBirthFrom()!= null){
			ret += addDateLimit("cu.birth_date",cs.getBirthFrom(),null);
		}
		
		if(cs.getBirthTo()!= null){
			ret += addDateLimit("cu.birth_date",null,cs.getBirthTo());
		}
		
		if(cs.getCreatedFrom()!= null){
			ret += addDateLimit("cu.created",cs.getCreatedFrom(),null);
		}
		
		if(cs.getCreatedTo()!= null){
			ret += addDateLimit("cu.created",null,cs.getCreatedTo());
		}
		
		if(cs.getUpdatedFrom()!= null){
			ret += addDateLimit("cu.updated",cs.getUpdatedFrom(),null);
		}
		
		if(cs.getUpdatedTo()!= null){
			ret += addDateLimit("cu.updated",null,cs.getUpdatedTo());
		}
		
		
		if(cs.getCreatedBy()!=null && !cs.getCreatedBy().isEmpty())
		{
			ret += " and cu.created_by in(";
			ret += listToIn(cs.getCreatedBy());
			ret += ")";
		}
		if(cs.getUpdatedBy()!=null && !cs.getUpdatedBy().isEmpty())
		{
			ret += " and cu.updated_by in(";
			ret += listToIn(cs.getUpdatedBy());
			ret += ")";
		}
		
		if(cs.getCgGroup()!=null && !cs.getCgGroup().isEmpty())
		{
			ret += " and cg.c_group in(";
			ret += listToIn(cs.getCgGroup());
			ret += ")";
		}
		
		if(sFilled(cs.getCommDevName()))
		{
			ret += strictString("comm.value_text",cs.getCommDevName(),cs.getStrict());
		}
		
		return ret;
	}
	
	private String addDateLimit(String field,Date from, Date to){
		String ret = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		if(to != null){
			ret += " and "+field+"<= to_date('" +format.format(to)+"','yyyy-mm-dd') + 1 ";
			
		}
		if(from != null){
			ret += " and "+field+">= to_date('" +format.format(from)+"','yyyy-mm-dd')";
			
		}
		
		return ret;
	}
	
	private String strictString(String field, String value,boolean strict){
		String ret = "";
		if(strict){
			  ret = " and "+field+" = '"+ value + "'";}
			else{
			  ret = " and lower("+field+") like '%"+value.toLowerCase()+"%'";}
		
		return ret;
	}
	
	private String listToIn(List<Long> list){
		String ret = "";
		Boolean firstPassed = false;
		for(Long l : list)
		{
			if(firstPassed){
				ret+=",";
			}
			ret += l;
			firstPassed = true;
		}
		return ret;
	}
	
	private Boolean sFilled(String s){
		if(s!= null && !s.isEmpty()){
			return true;
		}
		else return false;
	}
	
	private String addOrder(ClientSearch cs){
		String ret = "";
		if(cs.getOrderby()!= null && !cs.getOrderby().isEmpty()){
			switch(cs.getOrderby()){
			   case "firstName":
				 ret += "cu.first_name";
				 break;
				case "lastName":
				 ret += "cu.last_name";
				 break;
				case "birthDate":
				 ret += "cu.birth_date";
				 break;
				case "identityCode":
				 ret += "cu.identity_code";
				 break;
				case "cu.note":
				 ret += "cu.note";
				 break;
				case "created":
				 ret += "cu.created";
				 break;
				case "createdByName":
				 ret += "empc.first_name, empc.last_name";
				 break;
				case "updatedBy":
				 ret += "cu.updated";
				 break;
				case "updatedByName":
				 ret += "empu.first_name, empu.last_name";
				 break;
				case "cgName":
				 ret += "cg.name";
				 break;
				case "address":
				 ret += "adr.address";
				 break;
				case "house":
				 ret += "adr.house";
				 break;
				case "townCounty":
				 ret += "adr.town_county";
				 break;
				case "county":
				 ret += "adr.county";
				 break;
				case "zip":
				 ret += "adr.zip";
				 break;
				case "commType":
					 ret += "ctp.name";
					 break;
				case "commDev":
					 ret += "comm.value_text";
					 break;
				 default: ret = "";
			}
			
		}
		if(ret.length() > 0){
			return "order by " + ret +" "+cs.getSort();
		}
		return ret;
	}
	
	private String searchString = "select cu.customer\n" 
	        +",cu.first_name firstName\n"
			+",cu.last_name lastName\n"
			+",cu.identity_code identityCode\n"
			+",cu.note\n"
			+",cu.birth_date birthDate\n"
			+",cu.created\n"
			+",cu.updated\n"
			+",empu.employee updatedID\n"
			+",empu.first_name ||' '||empu.last_name updatedBy\n"
			+",empc.employee createdID\n"
			+",empc.first_name ||' '||empc.last_name createdBy\n"

			+",cg.c_group cgGroup\n"
			+",cg.name cgName\n"
			
			+",adr.cst_address cstAdress"
			+",adr.address address"
			+",adr.address_type addressType\n"
			+",adr.house\n"
			+",adr.town_county townCounty\n"
			+",adr.county\n"
			+",adr.zip\n"

			+",ctp.comm_device_type commDeviceType\n"
			+",ctp.name commDeviceTypeName\n"
			
			+",comm.comm_device commDev\n"
			+",comm.value_text commDevName\n"

			+"from customer cu \n"
			+"left join employee empu on empu.employee = cu.updated_by\n"
			+"left join employee empc on empc.employee = cu.created_by\n"
			+"left join cst_address adr on adr.customer = cu.customer{address_type}\n" // and adr.address_type = 1
			+"left join comm_device comm on comm.customer = cu.customer{comm_device}\n"
			+"left join comm_device_type ctp on ctp.comm_device_type = comm.comm_device_type\n"
			+"left join customer_group cgx on cgx.customer = cu.customer\n"
			+"left join c_group cg on cg.c_group = cgx.c_group\n";
    
	
}
