package cms.backend.dao;

import java.sql.Timestamp;

public class DAOUtils {
	public static Timestamp getTimeStamp(){
	 return	new Timestamp(System.currentTimeMillis());
	}
	
}
