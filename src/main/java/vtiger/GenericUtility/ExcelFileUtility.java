package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * the class consists of methods that deals with Excel
 * @param Sheet
 * @param row
 * @param cell
 * @return value
 * @throws throwable
 * @author ASUS
 *
 */
public class ExcelFileUtility
{
	public String getDataFromExcel(String Sheet,int rowNo,int cellNo) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstants.excelFilePath);
				Workbook wb = WorkbookFactory.create(fis);
				String value = wb.getSheet(Sheet).getRow(rowNo).getCell(cellNo).getStringCellValue();
	        return value;
	}
	 
	/**
	 * the method write the data in excel file
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @param data
	 * @throws Throwable 
	 */
	public void writeDataToExcel(String SheetName,int RowNo,int CellNo,String Data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.createSheet(SheetName);
		Row row = sheet.createRow(RowNo);
		Cell cell = row.createCell(CellNo);
		cell.setCellValue(Data);
		
		FileOutputStream fos=new FileOutputStream(IConstants.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}

}

