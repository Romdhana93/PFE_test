package utils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet sheet;

	private static XSSFWorkbook workBook;

	private static XSSFCell cell;

	private static XSSFRow row;

//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public ExcelUtils(String excelPath, String sheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream excelFile = new FileInputStream(excelPath);

			// Access the required test data sheet

			workBook = new XSSFWorkbook(excelFile);

			sheet = workBook.getSheet(sheetName);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}

	}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			cell = sheet.getRow(RowNum).getCell(ColNum);

			String cellData = cell.getStringCellValue();

			return cellData;

		} catch (Exception e) {

			return "";

		}

	}

	public static int getRowCount() {

		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;

	}

	public static int getColmnCount() {

		int columnCount = sheet.getRow(0).getLastCellNum();
		return columnCount;

	}

	public static Object[][] testData(String excelPath, String sheetName) throws Exception {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = ExcelUtils.getRowCount();
		int colCount = ExcelUtils.getColmnCount();

		Object data[][] = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				String cellData = excel.getCellData(i, j);

				data[i - 1][j] = cellData;
				System.out.println("*****hello data*****");
				System.out.println(data);
			}

		}
		return data;
	}

}
