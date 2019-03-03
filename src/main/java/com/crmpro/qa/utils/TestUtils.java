package com.crmpro.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crmpro.qa.base.CRMTestBase;

public class TestUtils extends CRMTestBase {

	public static void implicitWait(int x) {
		driver.manage().timeouts().implicitlyWait(x, TimeUnit.SECONDS);
	}

	static Workbook book;
	static Sheet sheet;
	public static String Test_Data_Path = "G:\\MY Workspace\\CRMPRO_QA\\src\\main\\java\\com\\crmpro\\qa\\testdata\\FreeCrmTestData.xlsx";

	public static Object[][] getTestData(String sheetName) {

		FileInputStream file = null;
		try {
			file = new FileInputStream(Test_Data_Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][colCount];
		System.out.println("Row count is: " + rowCount + " & coloumn count is: " + colCount);

		for (int i = 0; i < rowCount; i++) {
			for (int k = 0; k < colCount; k++) {
				Cell a = sheet.getRow(i + 1).getCell(k);
				//format the cells as per data type
				data[i][k] = getCellValueAsString(a);
			}
		}
		return data;
	}

	public static String getCellValueAsString(Cell cell) {
		String strCellValue = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				strCellValue = cell.toString();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					strCellValue = dateFormat.format(cell.getDateCellValue());
				} else {
					Double value = cell.getNumericCellValue();
					Long longValue = value.longValue();
					strCellValue = new String(longValue.toString());
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				strCellValue = new String(new Boolean(cell.getBooleanCellValue()).toString());
				break;
			case Cell.CELL_TYPE_BLANK:
				strCellValue = "";
				break;
			}
		}
		return strCellValue;
	}
}
