package calculator;

public class CalculatorController {

	private final CalculatorModel model;
	private Calculation calculation;


	public CalculatorController(CalculatorModel model, Calculation calculation) {
		this.model = model;
		this.calculation = calculation;
	}

	public void push(char charAt) {
		
		int number;
		
		if (SignMapper.isSign(charAt)) {
			calculation.sign(SignMapper.getSign(charAt));
		} else {
			number = Numeric.getNumeric(charAt);
			calculation.number(number);
		}
				
		String displayString = transformValue(calculation.getValue());
		
		model.setDisplay(displayString);
	}


	
	private String transformValue(double currentValue) {
		String stringValue = "" + currentValue;
		if (Math.floor(currentValue) != currentValue) {
			return stringValue;
		} else {
			return stringValue.substring(0, stringValue.length() - 1);
		}
	}
}