package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Author Gladson Antony
 * @Date 21-Feb-2017
 */
public class ExcelUtils 
{
	private static XSSFSheet xlsxWorkSheet;
	private static XSSFWorkbook xlsxWorkBook;
	private static XSSFCell xlsxCell;
	@SuppressWarnings("unused")
	private static XSSFRow xlsxRow;

	private static HSSFSheet xlsWorkSheet;
	private static HSSFWorkbook xlsWorkBook;
	private static HSSFCell xlsCell;
	@SuppressWarnings("unused")
	private static HSSFRow xlsRow;

	/** To get the Excel-XLSX File with Path and SheetName */
	public static void getExcelFile(String Path,String SheetName) throws Exception 
	{
		try 
		{
			File file = new File(Path);
			if(file.getAbsolutePath().endsWith(".xlsx"))
			{
				FileInputStream fis = new FileInputStream(file);
				xlsxWorkBook = new XSSFWorkbook(fis);
				xlsxWorkSheet = xlsxWorkBook.getSheet(SheetName);
			}
			else if(file.getAbsolutePath().endsWith(".xls"))
			{
				FileInputStream fis = new FileInputStream(file);
				xlsWorkBook = new HSSFWorkbook(fis);
				xlsWorkSheet = xlsWorkBook.getSheet(SheetName);
			}
		} 
		catch (Exception e)
		{
			throw (e);
		}
	}


	/** To Return the Excel-XLSX Values given Path to the File and Sheet Name */
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception
	{   
		Object[][] tabArray = null;
		try
		{
			File file = new File(FilePath);	
			if(file.getAbsolutePath().endsWith(".xlsx"))
			{
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsxWorkBook = new XSSFWorkbook(ExcelFile);
				xlsxWorkSheet = xlsxWorkBook.getSheet(SheetName);

				int startRow = 1;
				int startCol = 0;
				int ci,cj;
				int totalRows = ExcelUtils.xlsxRowCount();
				int totalCols = ExcelUtils.xlsxColumnCount();
				tabArray=new Object[totalRows-1][totalCols];
				ci=0;
				for (int i=startRow;i<totalRows;i++) 
				{           	   
					cj=0;
					for (int j=startCol;j<totalCols;j++)
					{
						tabArray[ci][cj]=getCellData_XLSX(i,j);
						cj++;
					}
					ci++;
				}
			}
			else if(file.getAbsolutePath().endsWith(".xls"))
			{
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsWorkBook = new HSSFWorkbook(ExcelFile);
				xlsWorkSheet = xlsWorkBook.getSheet(SheetName);

				int startRow = 1;
				int startCol = 0;
				int ci,cj;
				int totalRows = ExcelUtils.xlsRowCount();
				int totalCols = ExcelUtils.xlsColumnCount();
				tabArray=new Object[totalRows-1][totalCols];
				ci=0;
				for (int i=startRow;i<totalRows;i++) 
				{           	   
					cj=0;
					for (int j=startCol;j<totalCols;j++)
					{
						tabArray[ci][cj]=getCellData_XLS(i,j);
						cj++;
					}
					ci++;
				}
			}
		}
		catch (FileNotFoundException e)
		{
			throw new Exception("Could not Find the Excel File/Sheet");
		}
		catch (Exception e)
		{
			throw new Exception("Could not Open the Excel File");
		}
		return(tabArray);
	}


	/** To Return the Excel-XLSX Values given Path to the File */
	public static Object[][] getTableArray(String FilePath) throws Exception
	{   
		Object[][] tabArray = null;
		try
		{
			File file = new File(FilePath);			
			if(file.getAbsolutePath().endsWith(".xlsx"))
			{
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsxWorkBook = new XSSFWorkbook(ExcelFile);
				xlsxWorkSheet = xlsxWorkBook.getSheetAt(0);

				int startRow = 1;
				int startCol = 0;
				int ci,cj;
				int totalRows = ExcelUtils.xlsxRowCount();
				int totalCols = ExcelUtils.xlsxColumnCount();
				tabArray=new Object[totalRows-1][totalCols];
				ci=0;
				for (int i=startRow;i<totalRows;i++) 
				{           	   
					cj=0;
					for (int j=startCol;j<totalCols;j++)
					{
						tabArray[ci][cj]=getCellData_XLSX(i,j);
						cj++;
					}
					ci++;
				}
			}
			else if(file.getAbsolutePath().endsWith(".xls"))
			{
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsWorkBook = new HSSFWorkbook(ExcelFile);
				xlsWorkSheet = xlsWorkBook.getSheetAt(0);

				int startRow = 1;
				int startCol = 0;
				int ci,cj;
				int totalRows = ExcelUtils.xlsRowCount();
				int totalCols = ExcelUtils.xlsColumnCount();
				tabArray=new Object[totalRows-1][totalCols];
				ci=0;
				for (int i=startRow;i<totalRows;i++) 
				{           	   
					cj=0;
					for (int j=startCol;j<totalCols;j++)
					{
						tabArray[ci][cj]=getCellData_XLS(i,j);
						cj++;
					}
					ci++;
				}
			}
		}
		catch (FileNotFoundException e)
		{
			throw new Exception("Could not Find the Excel File/Sheet");
		}
		catch (Exception e)
		{
			throw new Exception("Could not Open the Excel File");
		}
		return(tabArray);
	}


	/** To get cell data from Excel-XLSX */
	public static Object getCellData_XLSX(int RowNum, int ColNum) throws Exception
	{
		Object CellData = null;
		try
		{
			xlsxCell = xlsxWorkSheet.getRow(RowNum).getCell(ColNum);
			if(xlsxCell.getCellType() == Cell.CELL_TYPE_STRING )
			{
				String stringCellData = xlsxCell.getStringCellValue();
				CellData = stringCellData;
			}
			/*		else if(xlsxCell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			{
				double numericCellData =  xlsxCell.getNumericCellValue();
				CellData = numericCellData;
			}
			else if(xlsxCell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
			{
				boolean booleanCellData =  xlsxCell.getBooleanCellValue();
				CellData = booleanCellData;
			}	*/	
			return CellData;
		}
		catch (Exception e)
		{
			return"";
		}
	}

	/** To get cell data from Excel-XLS */
	public static Object getCellData_XLS(int RowNum, int ColNum) throws Exception
	{
		Object CellData = null;
		try
		{
			xlsCell = xlsWorkSheet.getRow(RowNum).getCell(ColNum);
			if(xlsCell.getCellType() == Cell.CELL_TYPE_STRING )
			{
				String stringCellData = xlsCell.getStringCellValue();
				CellData = stringCellData;
			}
			/*		else if(xlsCell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			{
				double numericCellData =  xlsCell.getNumericCellValue();
				CellData = numericCellData;
			}
			else if(xlsCell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
			{
				boolean booleanCellData =  xlsCell.getBooleanCellValue();
				CellData = booleanCellData;
			}	*/	
			return CellData;
		}
		catch (Exception e)
		{
			return"";
		}
	}

	/** To get Excel-XLSX Row Count */
	public static int xlsxRowCount()
	{
		int rowNum = xlsxWorkSheet.getLastRowNum()+1;
		return rowNum;
	}

	/** To get Excel-XLS Row Count */
	public static int xlsRowCount()
	{
		int rowNum = xlsWorkSheet.getLastRowNum()+1;
		return rowNum;
	}

	/** To get Excel-XLSX Column Count */
	public static int xlsxColumnCount()
	{
		int rowNum = xlsxWorkSheet.getRow(0).getLastCellNum();
		return rowNum;
	}

	/** To get Excel-XLS Column Count */
	public static int xlsColumnCount()
	{
		int rowNum = xlsWorkSheet.getRow(0).getLastCellNum();
		return rowNum;
	}
}