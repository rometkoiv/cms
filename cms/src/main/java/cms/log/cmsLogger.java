package cms.log ;

import org.apache.log4j.*;



public class cmsLogger  {

	static Logger logger = Logger.getLogger(cmsLogger.class);

	public  static void Log(String method_name,String msg)
	{
		String log_row="CMS_ERROR:" + " method=" + method_name + " error_message=" + msg;

		try
		{logger.info(log_row);}
		catch(Exception ex)
		{ System.out.println("cmsLogger.Log():" + ex.getMessage());}
	}
	
	public  static void Inform(String method_name,String msg)
	{
		String log_row="CMS_INFO:" + " " + method_name + ":" + msg;

		try
		{logger.info(log_row);}
		catch(Exception ex)
		{ System.out.println("cmsLogger.Log():" + ex.getMessage());}
	}

	public static void LogMessage(String msg)
	{
		String log_row="CMS_MESSAGE:"  + msg;

		try
		{ logger.info(log_row);}
		catch(Exception ex)
		{ System.out.println("cmsLogger.Log():" + ex.getMessage());}

	}
}
