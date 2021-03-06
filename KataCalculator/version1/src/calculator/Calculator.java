package calculator;

import javax.swing.JFrame;

public class Calculator {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    CalculatorModel model = new CalculatorModel();
    Calculation calculation = new StandardCalculation();

    CalculatorController controller = new CalculatorController(model, calculation);
    CalculatorView view = new CalculatorView(model, controller);
    view.materializeView(frame.getContentPane());
    view.updateView();

    frame.pack();
    frame.setVisible(true);
	}
}
