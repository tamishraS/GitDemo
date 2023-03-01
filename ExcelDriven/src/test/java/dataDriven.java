import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\tamishra.senapati\\Downloads\\ExcelLink1.xlsx.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets= workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++) {
			
		if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
			XSSFSheet sheet= workbook.getSheetAt(i);
			Iterator<Row> rows= sheet.rowIterator();
			Row fstRow= rows.next();
			Iterator<Cell> cells= fstRow.cellIterator();
			
			while(cells.hasNext()) {
				
				Cell value= cells.next();
				String cellValue= value.getStringCellValue();
			}
		}
		}
	}

}
