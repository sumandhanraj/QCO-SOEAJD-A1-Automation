package vtiger.practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class PropertiedEx 
{
   public static void main(String[] args) throws IOException 
   {
	//step 1 read the file
	   FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\common.properties");
	   //step 2 create obj for properties
	   Properties pro=new Properties();
	   
	   //step 3 load all 
	   pro.load(fis);
	   //step 4 provide value
	   Object value = pro.getProperty("password");
	   System.out.println(value);
}
}
