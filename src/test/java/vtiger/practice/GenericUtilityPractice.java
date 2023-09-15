package vtiger.practice;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;


public class GenericUtilityPractice 
{
	public static void main(String[] args) throws Throwable,NullPointerException  
	{
		JavaUtility jutil=new JavaUtility();
		int value = jutil.getRandomNumber();
		System.out.println(value);
		String date = jutil.getSystemDate();
		System.out.println(date);
		
		PropertyFileUtility putil=new PropertyFileUtility();
		String value1 = putil.getDataFromProperty("browser");
		System.out.println(value1);
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		String data = eutil.getDataFromExcel("Organization", 0, 0);
		System.out.println(data);
		
		 eutil.writeDataToExcel("sample", 0, 0, "Dhanraj");
		System.out.println("Data added");
	}
	


}
