package cms.backend.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import cms.backend.db.dbConnection;
import cms.log.cmsLogger;

public class DistinctSearchDAO {
	private String sql;
	private Connection db;
	
	public DistinctSearchDAO()
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
	  
	public Map<Long,String> distinctEmployees()
	  {
		Statement newStatement = null;
		ResultSet localResultSet = null;
		
		Map<Long,String> empList = new LinkedHashMap<Long,String>();
	    
	    this.sql = "select distinct employee, first_name ||' '||last_name eName from employee";
	    
	    try
	    {
	    	newStatement = db.createStatement();
	    	localResultSet = newStatement.executeQuery(this.sql);
	      
	      if(localResultSet!=null){
	      
	      while (localResultSet.next())
	      {
	      
	      empList.put(localResultSet.getLong("employee"), localResultSet.getString("eName"));
	        
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
	    return empList;
	  }
	public Map<Long,String> distinctGroups()
	  {
		Statement newStatement = null;
		ResultSet localResultSet = null;
		
		Map<Long,String> empList = new LinkedHashMap<Long,String>();
	    
	    this.sql = "select c_group, name from c_group order by name";
	    
	    try
	    {
	    	newStatement = db.createStatement();
	    	localResultSet = newStatement.executeQuery(this.sql);
	      
	      if(localResultSet!=null){
	      
	      while (localResultSet.next())
	      {
	      
	      empList.put(localResultSet.getLong("c_group"), localResultSet.getString("name"));
	        
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
	    return empList;
	  }
	
	public Map<Long,String> commDeviceTypeList()
	  {
		Statement newStatement = null;
		ResultSet localResultSet = null;
		
		Map<Long,String> typeList = new LinkedHashMap<Long,String>();
	    
	    this.sql = "select comm_device_type,name from comm_device_type order by comm_device_type";
	    
	    try
	    {
	    	newStatement = db.createStatement();
	    	localResultSet = newStatement.executeQuery(this.sql);
	      
	      if(localResultSet!=null){
	      
	      while (localResultSet.next())
	      {
	      
	      typeList.put(localResultSet.getLong("comm_device_type"), localResultSet.getString("name"));
	        
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
	    return typeList;
	  }
	
	public Long employeeInUse(Long id)
	  {
		Statement newStatement = null;
		ResultSet localResultSet = null;
		Long ret = new Long(0);
		this.sql = "select sum(nr) total from (";
	    this.sql += "select count(1) nr from customer where created_by = "+id+" or updated_by = "+id;
	    this.sql += "union select count(1) nr from customer_group where created_by = "+id;
	    this.sql +=  "union select count(1) nr from c_group where created_by = "+id+"  or updated_by = "+id;
	    this.sql += "union select count(1) nr from employee where created_by = "+id+"  or updated_by = "+id;
	    this.sql += "union select count(1) nr from cst_address where created_by = "+id+"  or updated_by = "+id;
	    this.sql += ")d";
	    try
	    {
	    	
	      newStatement = db.createStatement();
	      localResultSet = newStatement.executeQuery(this.sql);
	      
	      if(localResultSet!=null){
	      while (localResultSet.next())
	      {
	    	  
	        ret = localResultSet.getLong("total");
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
	    return ret;
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
	
	
	
}
