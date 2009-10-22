package com.strumtheagile.katafizzbuzz;

public class FizzBuzz {

	private int limit;

	public FizzBuzz(int limit) {
		this.limit = limit;
	}
	
	public String[] sayIt() {
		String[] result = new String[this.limit];
		
		for (int i = 0; i < this.limit; i++) {
			result[i] = atTime(i + 1);
		}
		
		return result;
	}

	private String atTime(int i) {
		
		String result = "";
		
		if (generateFizz(i))
			result += "Fizz";
		if (generateBuzz(i))
			result += "Buzz";
		
		if (result.isEmpty())
		    result = "" + i + "";
		
		return result;
	}

	private boolean generateBuzz(int i) {
		return i % 5 == 0 || ((i - 5) % 10 == 0);
	}

	private boolean generateFizz(int i) {
		return i % 3 == 0 || ((i -3 ) % 10 == 0);
	}

}
