package com.qa.manage.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcelFile {

	File file;
	FileInputStream inputStream;
	FileOutputStream outputStream;
	Workbook workbook = null;
	String fileExtensionName;
	Sheet sheet;
	int rowCount;

	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {

		file = new File(filePath + "\\" + fileName);

		inputStream = new FileInputStream(file);

		fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			workbook = new XSSFWorkbook(inputStream);

		} else if (fileExtensionName.equals(".xls")) {

			workbook = new HSSFWorkbook(inputStream);

		}

		sheet = workbook.getSheet(sheetName);

		// Get the current count of rows in excel file

		rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Get the first row from the sheet

		Row row = sheet.getRow(0);

		// Create a new row and append it at last of sheet

		Row newRow = sheet.createRow(rowCount + 1);

		// Create a loop over the cell of newly created Row

		for (int j = 0; j < row.getLastCellNum(); j++) {

			// Fill data in row

			Cell cell = newRow.createCell(j);

			cell.setCellValue(dataToWrite[j]);

		}

		// Close input stream

		inputStream.close();

		// Create an object of FileOutputStream class to create write data in excel file

		outputStream = new FileOutputStream(file);

		// write data in the excel file

		workbook.write(outputStream);

		// close output stream

		outputStream.close();

	}
}
