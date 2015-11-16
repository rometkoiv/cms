package cms.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 

public class File {
  public static String getLog(){
	  StringBuilder sb = new StringBuilder();
	  //System.out.println(System.getProperty("catalina.base")+"/webapps/120437-cms/log.txt");
	  try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("catalina.base")+"/webapps/120437-cms/log.txt")))
		{

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				sb.append(sCurrentLine+"\r\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
	  return sb.toString();
  }
}
