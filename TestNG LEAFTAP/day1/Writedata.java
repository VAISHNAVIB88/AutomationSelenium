package week2.day1;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writedata {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(".\\data\\testdat2.xlsx");
		XSSFWorkbook book = new XSSFWorkbook();
		 XSSFSheet sheet = book.createSheet("Sheet1");
		 
		 sheet.createRow(0).createCell(0).setCellValue("Company Name");
		 sheet.getRow(0).createCell(1).setCellValue("First Name");
		 sheet.getRow(0).createCell(2).setCellValue("LeadId");
		/*
		 * for(int i=0;i<=2;i++) { XSSFRow row=sheet.createRow(i); for(int j=0;j<=2;j++)
		 * { row.createCell(j).setCellValue("xyz"); } }
		 */
		 book.write(file);
         book.close();
	}

}
