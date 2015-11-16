package cms.backend.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import cms.log.cmsLogger;

public class dbConnection {
	
	  public static Connection getConnection()
	  {
	    Connection localConnection = null;
	    String str1 = "";
	    String str2 = "";
	    String str3 = "";
	    try
	    {
	      ResourceBundle localResourceBundle = ResourceBundle.getBundle("dbConnection");
	      Class.forName(localResourceBundle.getString("Driver"));
	      str3 = localResourceBundle.getString("url");
	      str2 = localResourceBundle.getString("usr");
	      str1 = localResourceBundle.getString("pwd");
	      localConnection = DriverManager.getConnection(str3, str2, str1);
	    }
	    catch (Exception localException)
	    {
	    	cmsLogger.Log("cms.backend.db.dbConnection.getConnection():", localException.getMessage());
	    }
	    return localConnection;
	  }
	  
	  public static void close(Connection paramConnection)
	  {
	    if (paramConnection != null) {
	      try
	      {
	        paramConnection.close();
	      }
	      catch (SQLException localSQLException)
	      {
	    	  cmsLogger.Log("cms.backend.db.dbConnection.close()", localSQLException.getMessage());
	      }
	    }
	  }
	  
	  public static void closeStatement(Statement paramStatement)
	  {
	    if (paramStatement != null) {
	      try
	      {
	        paramStatement.close();
	      }
	      catch (SQLException localSQLException)
	      {
	    	  cmsLogger.Log("cms.backend.db.dbConnection.closeStatement()", localSQLException.getMessage());
	      }
	    }
	  }
	  
	  public static void closeResultSet(ResultSet paramResultSet)
	  {
	    if (paramResultSet != null) {
	      try
	      {
	        paramResultSet.close();
	      }
	      catch (SQLException localSQLException)
	      {
	    	  cmsLogger.Log("cms.backend.db.dbConnection.closeResultSet()", localSQLException.getMessage());
	      }
	    }
	  }
}
