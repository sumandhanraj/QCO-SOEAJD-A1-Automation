package vtiger.practice;

public class GenericMethod {

	public static void main(String[] args) //caller
	{
	  int result=add(200,50);
	  System.out.println(result);
	}
		
		public static  int add(int a,int b)//calling
		{
			int c=a+b;
			return c;
		}

	

}
