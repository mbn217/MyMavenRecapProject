package TDDrecap;

import org.junit.Test;
import org.testng.Assert;

public class Calculator {
	

	
	
	
	@Test
	public void additionOfTwoNumbers() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(6,calculator.addTwoNumbers(2, 3));
	}

	private int addTwoNumbers(int i, int j) {
		// TODO Auto-generated method stub
		return i+j;
	}



	
	

}
