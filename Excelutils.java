package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutils {
	public String getDataFromExcel(String Sheetname,int Rownum,int Cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream File=new FileInputStream("src\\test\\resources\\fa1.xlsx");
		Workbook wb=WorkbookFactory.create(File);
		Sheet sh=wb.getSheet(Sheetname);
		Row rw=sh.getRow(Rownum);
		Cell C1=rw.getCell(Cellnum);
		String value=C1.getStringCellValue();
		return value;
	}
	}
		
	


