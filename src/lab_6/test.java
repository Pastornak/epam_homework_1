package lab_6;

import org.junit.Assert;
import org.junit.Test;

public class test {

	@Test
	public void test1() throws Exception{
		System.out.println("Test 1");
		String FILENAME = "src/lab_6/test1";
		Assert.assertEquals(IJones.getInstance().ijones(FILENAME), 5);
	}
	
	@Test
	public void test2() throws Exception{
		System.out.println("Test 2");
		String FILENAME = "src/lab_6/test2";
		Assert.assertEquals(IJones.getInstance().ijones(FILENAME), 2);
	}
	
	@Test
	public void test3() throws Exception{
		System.out.println("Test 3");
		String FILENAME = "src/lab_6/test3";
		Assert.assertEquals(IJones.getInstance().ijones(FILENAME), 201684);
	}
}
