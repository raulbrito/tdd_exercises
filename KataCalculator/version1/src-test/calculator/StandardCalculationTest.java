package calculator;



import junit.framework.Assert;
import junit.framework.TestCase;


public class StandardCalculationTest extends TestCase {
	

	public void testInputOneNumber() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(1);
		Assert.assertEquals(calculation.getValue(), 1.0);
	}
	
	public void testInputTwoNumbers() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(4);
		calculation.number(7);
		
		Assert.assertEquals(calculation.getValue(), 47.0);
	}
	
	public void testAddTwoNumbers() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(2);
		calculation.number(2);
		calculation.sign(Sign.PLUS);
		calculation.number(3);
		calculation.sign(Sign.EQUALS);
		
		Assert.assertEquals(25.0, calculation.getValue());
	}
	
	public void testClearAfterCalculation() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(2);
		calculation.number(2);
		calculation.sign(Sign.PLUS);
		calculation.number(3);
		calculation.sign(Sign.EQUALS);
		calculation.sign(Sign.CLEAR);
			
		Assert.assertEquals(0.0, calculation.getValue());
		
	}
	
	public void testInputDecimalNumber() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(6);
		calculation.sign(Sign.DOT);
		calculation.number(4);
		Assert.assertEquals(6.4, calculation.getValue());
	}
	
	public void testAddTwoDecimalNumbers() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(8);
		calculation.sign(Sign.DOT);
		calculation.number(7);
		calculation.sign(Sign.PLUS);
		calculation.number(2);
		calculation.sign(Sign.DOT);
		calculation.number(3);
		calculation.sign(Sign.EQUALS);
		
		Assert.assertEquals(11.0, calculation.getValue());
	}
	
	public void testClearAfterHavingDot() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(3);
		calculation.sign(Sign.DOT);
		calculation.number(2);
		calculation.sign(Sign.CLEAR);
		calculation.number(1);
		calculation.number(8);
		calculation.sign(Sign.PLUS);
		calculation.number(2);
		calculation.sign(Sign.EQUALS);
		
		Assert.assertEquals(20.0, calculation.getValue());
	}
	
	public void testDoMinus() {
		Calculation calculation = new StandardCalculation();
			
		calculation.number(4);
		calculation.sign(Sign.MINUS);
		calculation.number(2);
		calculation.sign(Sign.EQUALS);
		
		Assert.assertEquals(2.0, calculation.getValue());
	}
	
	public void testDoMinusWithNegativeResult() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(2);
		calculation.sign(Sign.MINUS);
		calculation.number(4);
		calculation.sign(Sign.EQUALS);
		
		Assert.assertEquals(-2.0, calculation.getValue());
	}
	
	public void testDoMultiplication() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(2);
		calculation.sign(Sign.MULTIPLY);
		calculation.number(4);
		calculation.sign(Sign.EQUALS);
		
		Assert.assertEquals(8.0, calculation.getValue());
	}
	
	public void testDoMultiplicationWithDecimalNumbers() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(2);
		calculation.sign(Sign.DOT);
		calculation.number(9);
		calculation.sign(Sign.MULTIPLY);
		calculation.number(5);
		calculation.sign(Sign.DOT);
		calculation.number(4);
		calculation.sign(Sign.EQUALS);
		
		Assert.assertEquals(15.66, calculation.getValue());
	}
	
	public void testDoMultiplicationWithNegativeResult() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(3);
		calculation.sign(Sign.MULTIPLY);
		calculation.number(-4);
		calculation.number(5);
		calculation.sign(Sign.EQUALS);
		
		Assert.assertEquals(-135.0, calculation.getValue());
	}	
	
	public void testOperatorShouldActAsEqualsAndEvaluate() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(3);
		calculation.sign(Sign.PLUS);
		calculation.number(2);
		calculation.sign(Sign.PLUS);
		
		Assert.assertEquals(5.0, calculation.getValue());
	}
	
	public void testOperatorTwiceShouldActAsEqualsAndEvaluate() {
		Calculation calculation = new StandardCalculation();
		
		calculation.number(3);
		calculation.sign(Sign.PLUS);
		calculation.number(2);
		calculation.sign(Sign.PLUS);
		calculation.sign(Sign.PLUS);
		
		Assert.assertEquals(5.0, calculation.getValue());
	}
	
	public void testDoDivision() {
		Calculation calculation = new StandardCalculation();
		calculation.number(4);
		calculation.sign(Sign.DIVISION);
		calculation.number(2);
		calculation.sign(Sign.EQUALS);
		
		Assert.assertEquals(2.0, calculation.getValue());
	}
	
	public void testDoDivisionWithInfiniteResult() {
		Calculation calculation = new StandardCalculation();
		calculation.number(1);
		calculation.sign(Sign.DIVISION);
		calculation.number(3);
		calculation.sign(Sign.EQUALS);


		Assert.assertEquals(0.3333333333333333, calculation.getValue());
	}
	
	
	public void testDoSignalOnPositiveNumber() {
		Calculation calculation = new StandardCalculation();
		calculation.number(3);
		calculation.sign(Sign.DOT);
		calculation.number(6);
		calculation.sign(Sign.SIGNAL);
		
		Assert.assertEquals(-3.6, calculation.getValue());
	}

	public void testDoSignalOnNegativeNumber() {
		Calculation calculation = new StandardCalculation();
		calculation.number(-3);
		calculation.sign(Sign.DOT);
		calculation.number(6);
		calculation.sign(Sign.SIGNAL);
		
		Assert.assertEquals(3.6, calculation.getValue());
	}

	
	public void testGetValueAfterSign() {
		Calculation calculation = new StandardCalculation();
		calculation.number(2);
		calculation.sign(Sign.PLUS);
		
		Assert.assertEquals(2.0, calculation.getValue());
	}
	

	public void testDoRoot () {
		Calculation calculation = new StandardCalculation();
		calculation.number(4);
		calculation.sign(Sign.ROOT);
		calculation.number(2);
		calculation.sign(Sign.EQUALS);
		
		Assert.assertEquals(2.0, calculation.getValue());
	}
	
	public void testDoPower() {
		Calculation calculation = new StandardCalculation();
		calculation.number(4);
		calculation.sign(Sign.POWER);
		calculation.number(4);
		calculation.sign(Sign.EQUALS);
		
		Assert.assertEquals(256.0, calculation.getValue());
	}

}
