package maven;


import org.testng.annotations.Test;

public class ExampleTest {
	
	@Test
	public void print()
	{
		String url = System.getProperty("url");
		String Username = System.getProperty("username");
		String password = System.getProperty("password");
		System.out.println(url);
		System.out.println(Username);
		System.out.println(password);
	}

}
