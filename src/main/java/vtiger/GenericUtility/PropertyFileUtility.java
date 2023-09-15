package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility 
/**
 * this method reads the data from property file based on key
 * @param key
 * @return value
 * @throws throwable
 */

{
	public String getDataFromProperty(String key) throws Throwable
	{
	
  FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\common.properties");
  Properties pro=new Properties();
  pro.load(fis);
  String value = pro.getProperty(key);
  return value;
	}
}
