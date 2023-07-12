package practice1;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.greentreand.genericutility.ExcelUtlity;

public class DP2Test {
	
	@Test(dataProvider = "getDataFromExcel")
	public void ecelTest(Object src,Object dest, Object noperson,Object eachCost, Object totalCost)
	{
		System.out.println("src"+src);
		System.out.println("dest"+dest);
		System.out.println("noperson"+noperson);
		System.out.println("eachCost"+eachCost);
		System.out.println("totalCost"+totalCost);
	}
	
	@DataProvider
	
	public Object[][] getDataFromExcel() throws IOException, Throwable
	{
		ExcelUtlity eLib=new ExcelUtlity();
		int rowCount=eLib.getRowCount("./testdata/dataprovidertestScript.xlsx", "dataProvider");
		System.out.println(rowCount);
		int cellcount=eLib.getCellCount("./testdata/dataprovidertestScript.xlsx", "dataProvider");
		System.out.println(cellcount);
		
		Object[][] obj=new Object[rowCount][cellcount];			
		for(int i=0;i<rowCount;i++)
		{	
			System.out.println("bye");
			for(int j=0;j<cellcount;j++)
			{				
				obj[i][j]=eLib.getDataFromExcel("./testdata/dataprovidertestScript.xlsx", "dataProvider",i, j);
				System.out.println(obj[i][j]);
			}
			System.out.println("hi");
		}
		return obj;	
		
		
	}

}
