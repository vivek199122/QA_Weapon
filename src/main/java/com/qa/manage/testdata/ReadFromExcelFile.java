package com.qa.manage.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcelFile {

	File file;
	FileInputStream inputStream;
	Workbook workbook = null;
	String fileExtensionName;
	Sheet sheet;
	int rowCount;

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

		file = new File(filePath + "\\" + fileName);

		inputStream = new FileInputStream(file);

		fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			workbook = new XSSFWorkbook(inputStream);

		} else if (fileExtensionName.equals(".xls")) {

			workbook = new HSSFWorkbook(inputStream);
		}

		sheet = workbook.getSheet(sheetName);

		// Find number of rows in excel file

		rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it

		for (int i = 0; i < rowCount + 1; i++) {

			Row row = sheet.getRow(i);

			// Create a loop to print cell values in a row

			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Print Excel data in console

				System.out.print(row.getCell(j).getStringCellValue() + "|| ");

			}

			System.out.println();
		}

	}
}
