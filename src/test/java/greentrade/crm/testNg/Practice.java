package greentrade.crm.testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice {
	
	@BeforeSuite
	public void bs()
	{
		System.out.println("Before suit");
	}
	
	@BeforeTest
	public void bt()
	{
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void bc()
	{
		System.out.println("Before class");
	}
	
	@Test
	public void sheela()
	{
		System.out.println("Sheela");
	}
	
	@AfterClass
	public void ac()
	{
		System.out.println("After class");
	}
	
	
	@AfterTest
	public void at()
	{
		System.out.println("After test");
	}
	
	@AfterSuite
	public void as()
	{
		System.out.println("After suite");
	}
	
	
	

}
