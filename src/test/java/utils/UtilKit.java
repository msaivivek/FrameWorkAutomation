package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
	
	static FileInputStream fis1;
	public static HashMap<String, String> getTestDataFromExcel(String testCaseId){
		
		
		try {
		 fis1=new FileInputStream("src\\test\\resources\\testdata\\excel\\Adactin Master Test Data.xlsx");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		XSSFWorkbook wb= null;
		try {
			 wb=new XSSFWorkbook(fis1);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		XSSFSheet ws = wb.getSheet("com.adactin");
		ArrayList<Row> testCaseRows = getTestCaseRows(ws,testCaseId);
		HashMap<String, String> testDataMap = new HashMap<String, String>();
		
		for (int i = 0; i < testCaseRows.size(); i++) {
			
			int noOfCells=testCaseRows.get(i).getLastCellNum();
			for (int j = 0; j <noOfCells; j++) {
				testDataMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(), testCaseRows.get(1).getCell(j).getStringCellValue());
				
			}
			
		}
		
		return testDataMap;
		
	}
	private static ArrayList<Row> getTestCaseRows(XSSFSheet ws, String testCaseId) {
		ArrayList<Row> allRows = new ArrayList<Row>();
		for (int i = 0; i < ws.getLastRowNum(); i++) {
			
			if (ws.getRow(i)!=null) {
				
				allRows.add(ws.getRow(i));
				
			}
			
		}
		ArrayList<Row> testCaseRows = new ArrayList<Row>();
		
		for (int i = 0; i < allRows.size(); i++) {
			
			if (allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCaseId)) {
				testCaseRows.add(allRows.get(i));
				
			}
			
		}
		
		return testCaseRows;
	}
	
	
	

}
