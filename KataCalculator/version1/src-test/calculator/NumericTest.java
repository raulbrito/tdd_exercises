package calculator;


import junit.framework.Assert;
import junit.framework.TestCase;

public class NumericTest extends TestCase {

	public void testTestIfIsNumeric() {
		
		char [] numericChars = new char [] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int [] numericInts = new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		for (int i = 0; i < numericChars.length; i++) {
			Assert.assertEquals(Numeric.getNumeric(numericChars[i]), numericInts[i]);	
		}
	}

}
