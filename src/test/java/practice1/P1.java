package practice1;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P1 {
	@Test
	public void main() {
		
		// TODO Auto-generated method stub
		int[] a= {10,20,30,40};
		int[] b= {10,20,30,40};
		Assert.assertEquals(a, b, "Test is failed");
		assertTrue(10==10, "hi");
	}

}
