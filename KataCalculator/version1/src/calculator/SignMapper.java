package calculator;

import java.util.HashMap;
import java.util.Map;

public final class SignMapper {
	
	private SignMapper() {		
	}
	
	static private Map<Character, Sign> mapper = new HashMap<Character, Sign>();

	static {
		mapper.put('C', Sign.CLEAR);
		mapper.put('.', Sign.DOT);
		mapper.put('+', Sign.PLUS);
		mapper.put('=', Sign.EQUALS);
		mapper.put('-', Sign.MINUS);
		mapper.put('*', Sign.MULTIPLY);
		mapper.put('/', Sign.DIVISION);
		mapper.put('÷', Sign.DIVISION);
		mapper.put('±', Sign.SIGNAL);
		mapper.put('√', Sign.ROOT);
		mapper.put('^', Sign.POWER);
	}
	
	static boolean isSign(char charAt) {
		return (mapper.get(charAt) != null);
	}
	
	static Sign getSign(char charAt) {
		Sign sign = mapper.get(charAt);
		
		if (sign != null) {
			return sign;
		} else {
			throw new NoSignException(charAt);
		}
	}

}
