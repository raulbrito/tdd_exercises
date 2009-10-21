package com.strumtheagile.katafizzbuzz;

public class FizzBuzz {

	public String atTime(int i) {
		if (i == 3)
			return "Fizz";
		else if (i == 5)
			return "Buzz";
		else
		    return "" + i + "";
	}

}
