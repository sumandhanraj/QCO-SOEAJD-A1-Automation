package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;
/**
* this class contains all java generic utilities
* @author ASUS
*
*/
public class JavaUtility 


/**
 * this method generate random number for every execution
 */
{
public int getRandomNumber()
{
	Random r=new Random();
	int ran = r.nextInt(1000);
	return ran;
}

public String getSystemDate()
{
	Date d =new Date();
	String date = d.toString();
	return date;
			
}
}


