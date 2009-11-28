package calculator;

public class Numeric {
	
	private Numeric() {	
	}
	
	public static int getNumeric(char charAt) {
		Character character = Character.valueOf(charAt);
		return Integer.parseInt(character.toString());		
	}

}
