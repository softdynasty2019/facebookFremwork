package MyFramwork.Facebook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadriven {

	public ArrayList<String> getData(String Testcasename) throws IOException {

		ArrayList<String> a = new ArrayList <String>();

		FileInputStream fis = new FileInputStream("C:\\Users\\Basement_PC\\Desktop\\Git Fremwork\\facebookFremwork\\Facebook\\TestData.xlsx");// Its
																						// file
		XSSFWorkbook workbook = new XSSFWorkbook(fis);// Access For Excel
		int sheets = workbook.getNumberOfSheets();

		// System.out.println(sheets);5

		for (int i = 0; i < sheets; i++) {// It will loop[ for Each sheet

			if (workbook.getSheetName(i).equalsIgnoreCase("Data")) {

				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row Firstrow = rows.next();
				Iterator<Cell> cell = Firstrow.cellIterator();
				int k = 0;
				int coloum = 0;

				while (cell.hasNext()) {

					Cell value = cell.next();// It will take First Row Value from the cell

					if (value.getStringCellValue().equalsIgnoreCase("Testcase")) {

						// coloum Value

						coloum = k;

					}

					k++;

				}

				System.out.println(coloum);
				while (rows.hasNext()) {

					Row rowValue = rows.next();

					if (rowValue.getCell(coloum).getStringCellValue().equalsIgnoreCase(Testcasename)) {

						Iterator<Cell> cellValue = rowValue.cellIterator();

						while (cellValue.hasNext()) {
							
						Cell c=	cellValue.next();
						if (c.getCellTypeEnum()==CellType.STRING) {	

							a.add(c.getStringCellValue());

						}
						else {
							
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
							 
						}
					}
					
				}
			
			
		}
		

	}
		return a;

}

}



	