package com.leaftaps.ui.utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class ReadExcelData {
	public static String[][] readExcelData(String value) throws IOException {
		//Open the excel Sheet
		XSSFWorkbook book = new XSSFWorkbook("./testdata/"+ value +".xlsx");
		
		//Get the sheet
		XSSFSheet sheet = book.getSheetAt(0);
		
		//get the data from excel sheet
		//Get row size
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(lastRowNum);
		//Get Column size
		XSSFRow headerRow = sheet.getRow(0);
		
		short lastCellNum = headerRow.getLastCellNum();
		System.out.println(lastRowNum);
		
		String[][] data = new String[lastRowNum][lastCellNum];
		//Get the data
		for (int i = 1; i <= lastRowNum; i++) {
			//Iterate the Row
			XSSFRow row = sheet.getRow(i);
			//Column
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				String datas = cell.getStringCellValue();
				System.out.println(datas+"\t");
				data[i-1][j] = datas;
			}
			System.out.println();
		}
		return data;
	}

}
