package calculator;

public class StandardCalculation implements Calculation {
		
	private double leftValue = 0;
	private double currentValue = 0;
	private double decimalLevel = 0;
	private CalculationState operationTerm = CalculationState.LEFT_TERM;
	private Sign operationType;
	
	private static final int INTEGER_PART = 10;
	private static final double DECIMAL_PART = 0.1;

	@Override
	public double getValue() {
		return currentValue;
	}


	@Override
	public void number(int number) {
		double doubleNumber = number;
		if (operationTerm == CalculationState.OPERATION) {
			currentValue = 0;
			operationTerm = CalculationState.RIGHT_TERM;
		}
		if (isDecimal()) {
			currentValue *= INTEGER_PART;
		} else {
			doubleNumber = decimalLevel * doubleNumber;
			decimalLevel *= DECIMAL_PART;
		}
		if (isNegative()) {
			currentValue -= doubleNumber;
		} else {
			currentValue += doubleNumber;
		}
	}


	private boolean isNegative() {
		return currentValue < 0;
	}


	private boolean isDecimal() {
		return decimalLevel == 0;
	}


	@Override
	public void sign(Sign symbol) {
		
		switch(symbol) {
		case CLEAR:
			resetInformation();
			break;	
		case DOT:
			decimalLevel = DECIMAL_PART;
			break;
		case PLUS:
		case MINUS:
		case MULTIPLY:
		case DIVISION:
		case ROOT:
		case POWER:
			if (isLeftTerm()) {
				changeToOperationTerm(symbol);
			}
			if (isRightTerm()) {
				this.sign(Sign.EQUALS);
			}
			break;
		case EQUALS:
			if (isNotEqualsTerm()) {
				calculateResult();
				currentValue = leftValue;
				operationTerm = CalculationState.EQUALS;
			}
			break;
		case SIGNAL:
			if (isLeftTerm() || isRightTerm()) {
				currentValue *= -1;
			}
			break;
		default:
			throw new UnsupportedOperationException();
		}
		
	}

	private boolean isRightTerm() {
		return operationTerm == CalculationState.RIGHT_TERM;	
	}


	private void resetInformation() {
		leftValue = 0;
		currentValue = 0;
		operationTerm = CalculationState.LEFT_TERM;
		decimalLevel = 0;
	}


	private void calculateResult() {
		if (operationType == Sign.PLUS) {
			leftValue += currentValue;
		}
		if (operationType == Sign.MINUS) {
			leftValue -= currentValue;
		}
		if (operationType == Sign.MULTIPLY) {
			leftValue *= currentValue;
		}
		if (operationType == Sign.DIVISION) {
			leftValue /= currentValue;
		}
		if (operationType == Sign.ROOT) {
			leftValue = Math.pow(leftValue, 1.0/currentValue);
		}
		if (operationType == Sign.POWER) {
			leftValue = Math.pow(leftValue, currentValue);
		}
	}


	private boolean isNotEqualsTerm() {
		return operationTerm != CalculationState.EQUALS;
	}


	private void changeToOperationTerm(Sign operation) {
		operationType = operation;
		leftValue = currentValue;
		decimalLevel = 0;
		operationTerm = CalculationState.OPERATION;
	}


	private boolean isLeftTerm() {
		return operationTerm == CalculationState.LEFT_TERM;
	}

}
