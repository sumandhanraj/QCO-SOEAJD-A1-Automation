package vtiger.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws Throwable 
	{
		//step 1 read the file in java format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
		
		//step 2 create woorkbookfactory
	   Workbook wb = WorkbookFactory.create(fis);
	   
	   //step 3 nabigate to sheet
	   Sheet sheet = wb.getSheet("Organization");
	   
	   //step 4 navigate to row
	   Row row = sheet.getRow(0);
	   
	   //step 5 navigate to cell
	  Cell cell = row.getCell(0);
	  
	  //step 5 get cell value
	  String value = cell.getStringCellValue();
	  System.out.println(value);
	
	}

}
