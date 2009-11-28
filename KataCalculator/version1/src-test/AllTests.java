import calculator.CalculatorControllerTest;
import calculator.NumericTest;
import calculator.StandardCalculationTest;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class AllTests {
	public static void main(String[] args) {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(HelloWorldTest.class);
		suite.addTestSuite(CalculatorControllerTest.class);
		suite.addTestSuite(NumericTest.class);
		suite.addTestSuite(StandardCalculationTest.class);
		TestRunner.run(suite);
	}
}
