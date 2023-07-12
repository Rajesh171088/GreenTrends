package greentrade.vendor.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Practice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./crmtestscript.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String text=wb.getSheet("Product").getRow(0).getCell(0).getStringCellValue();
		System.out.println(text);
		
		
	}

}
