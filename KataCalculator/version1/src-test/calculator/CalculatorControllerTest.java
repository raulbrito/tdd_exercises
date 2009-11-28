package calculator;

import calculator.CalculatorController;
import calculator.CalculatorModel;
import junit.framework.TestCase;

public class CalculatorControllerTest extends TestCase {  
	public void testItShouldInitializeToZero() throws Exception {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('C');
		assertEquals("0.", model.getDisplay());
	}
	
	public void testItShouldConcatenateTwoNumberPresses() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('1');
		controller.push('2');
		assertEquals("12.", model.getDisplay());
	}
	
	public void testItShouldConcatenateThreeNumberPresses() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('3');
		controller.push('6');
		controller.push('9');
		assertEquals("369.", model.getDisplay());
	}
	
	public void testItShouldSupportDecimalPoint() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('4');
		controller.push('.');
		controller.push('7');
		assertEquals("4.7", model.getDisplay());
	}
	
	public void testItShouldNotCareAboutSecondDecimalPoint() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('4');
		controller.push('.');
		controller.push('7');
		controller.push('.');
		controller.push('.');
		assertEquals("4.7", model.getDisplay());
	}
	
	public void testDoPlus() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('4');
		controller.push('+');
		controller.push('5');
		controller.push('=');
		assertEquals("9.", model.getDisplay());
	}
	
	public void testDoMinus() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('2');
		controller.push('-');
		controller.push('4');
		controller.push('=');
		assertEquals("-2.", model.getDisplay());
	}
	
	public void testDoMultiply() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('2');
		controller.push('*');
		controller.push('4');
		controller.push('=');
		assertEquals("8.", model.getDisplay());

	}
	
	public void testDoDivision() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('2');
		controller.push('/');
		controller.push('4');
		controller.push('=');
		assertEquals("0.5", model.getDisplay());

	}
	
	public void testPutSignal() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('2');
		controller.push('±');
		assertEquals("-2.", model.getDisplay());
		
	}
	
	public void testDoDivisionWithOtherSymbol() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('2');
		controller.push('÷');
		controller.push('4');
		controller.push('=');
		assertEquals("0.5", model.getDisplay());

	}
	
	public void testGetValueAfterSign() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('2');
		controller.push('+');
		
		assertEquals("2.", model.getDisplay());
	}
	

	public void testDoSquareRoot() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('4');
		controller.push('√');
		controller.push('2');
		controller.push('=');
		assertEquals("2.", model.getDisplay());
	}
	
	public void testDoPower() {
		CalculatorModel model = new CalculatorModel();
		Calculation calculation = new StandardCalculation();
		CalculatorController controller = new CalculatorController(model, calculation);
		controller.push('4');
		controller.push('^');
		controller.push('4');
		controller.push('=');		
		assertEquals("256.", model.getDisplay());
	}
	
	
//	public void testDoPower() {
//		CalculatorModel model = new CalculatorModel();
//		Calculation calculation = new StandardCalculation();
//		CalculatorController controller = new CalculatorController(model, calculation);
//		controller.push('^');
//		assertEquals("0.5", model.getDisplay());
//	}
	
	
	
	
	
	
}
