package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{

	public int getTotalRowCount(String sheetname) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		return rowcount;
	}
	
	
	
	
	public int getTotalCellCount(String sheetname) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet(sheetname);
		int cellcount=sh.getRow(0).getLastCellNum();
		return cellcount;
	}
	
	
	
	
	
	public void writedataintoexcel(String sheetname, int rowNo,int cellNo,String data) throws Throwable 
	
	{
		FileInputStream fi=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetname);
		sh.createRow(rowNo).createCell(cellNo).setCellValue(data);
		
		FileOutputStream fout = new FileOutputStream(IpathConstant.ExcelPath);
		wb.write(fout);
		
	}
	
	
	
	
	public String ReadDataFromExcel(String sheetname,int rowNo,int cellNo) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetname);
		 String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		 return value;
			
	}
	
	
	
	public HashMap<String,String> ReadMultipleDataFromExcel(String sheetname,int cellNo) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetname);
		
		int rowcount=sh.getLastRowNum();
		
		HashMap<String,String>map=new HashMap<String,String>();
		
		for(int i=0;i<=rowcount;i++)
		{
			String key=sh.getRow(i).getCell(cellNo).getStringCellValue();
			String value=sh.getRow(i).getCell(cellNo+1).getStringCellValue();
			map.put(key,value);
			
		}
		return map;
		
	}
	
	
}
