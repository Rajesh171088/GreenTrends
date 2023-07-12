package practice1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP1Test {
	
	@Test(dataProvider = "getData")
	public void useData(Object src,Object dest)	
	{
		System.out.print("Source: "+src+"=>");
		System.out.println("Dest: "+dest);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] o=new Object[3][2];
		
		o[0][0]="Bangalore";
		o[0][1]="Mysore";
		
		o[1][0]="Mysore";
		o[1][1]="Goa";
		
		o[2][0]="Mandya";
		o[2][1]="Gokarna";
		
		return o;
		
		
	}

}
