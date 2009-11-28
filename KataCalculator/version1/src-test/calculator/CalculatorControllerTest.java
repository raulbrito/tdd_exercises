package calculator;

import calculator.CalculatorController;
import calculator.CalculatorModel;
import junit.framework.TestCase;


public class CalculatorControllerTest extends TestCase {

	CalculatorModel model = new CalculatorModel();
	Calculation calculation = new StandardCalculation();
	CalculatorController controller;
	
	public void setUp() {
		 controller = new CalculatorController(model, calculation);		
	}
	public void testItShouldInitializeToZero() throws Exception {
		controller.push('C');
		assertEquals("0.", model.getDisplay());
	}
	
	public void testItShouldConcatenateTwoNumberPresses() {
		controller.push('1');
		controller.push('2');
		assertEquals("12.", model.getDisplay());
	}
	
	public void testItShouldConcatenateThreeNumberPresses() {
		bulkPush("369");
		assertEquals("369.", model.getDisplay());
	}
	
	public void testItShouldSupportDecimalPoint() {
		bulkPush("4.7");
		assertEquals("4.7", model.getDisplay());
	}
	
	public void testItShouldNotCareAboutSecondDecimalPoint() {
		bulkPush("4.7..");
		assertEquals("4.7", model.getDisplay());
	}
	
	public void testDoPlus() {
		bulkPush("4+5=");
		assertEquals("9.", model.getDisplay());
	}
	
	public void testDoMinus() {
		bulkPush("2-4=");
		assertEquals("-2.", model.getDisplay());
	}
	
	public void testDoMultiply() {
		bulkPush("2*4=");
		assertEquals("8.", model.getDisplay());

	}
	
	public void testDoDivision() {
		bulkPush("2/4=");
		assertEquals("0.5", model.getDisplay());

	}
	
	public void testPutSignal() {
		controller.push('2');
		controller.push('±');
		assertEquals("-2.", model.getDisplay());
		
	}
	
	public void testDoDivisionWithOtherSymbol() {
		bulkPush("2÷4=");
		assertEquals("0.5", model.getDisplay());

	}
	
	public void testGetValueAfterSign() {
		controller.push('2');
		controller.push('+');		
		assertEquals("2.", model.getDisplay());
	}
	

	public void testDoSquareRoot() {
		bulkPush("4√2=");
		assertEquals("2.", model.getDisplay());
	}
	
	public void testDoPower() {
		bulkPush("4^4=");		
		assertEquals("256.", model.getDisplay());
	}
	
	private void bulkPush(String push) {
		char[] list = push.toCharArray();
		for (int i = 0; i < list.length; i++) {
			controller.push(list[i]);
			
		}
	}
	
}
