package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcel {

	public static void main(String[] args) throws Throwable 
	{
		//step 1 open the file in  ja ba formaat
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
		
		//step 2 create woorkbook
	    Workbook wb = WorkbookFactory.create(fis);

	     //step 3 create sheet
	    Sheet sheet = wb.createSheet("Trail");
	
	   //step 4 create row
	   Row row = sheet.createRow(4);
	   
	   //step 5 create cell
	   Cell cell = row.createCell(5);
	   
	   //step 6 set the value into the cell
	   cell.setCellValue("chaitra");
	   
	   //step 7 open the file in java wrote format
	   FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
	   
	  // step 8 call the write method
	   wb.write(fos);
	   System.out.println("data added");
	   
	   //step 9 close the workbook
	   wb.close();
	   System.out.println("workbook closed");
	}

	
	
}
