package com.strumtheagile.katafizzbuzz;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class FizzBuzzTest {
	
	@Test
	public void fizz_buzz_for_first() {
		FizzBuzz fizzBuzz = new FizzBuzz(1);
		
		String[] result = fizzBuzz.sayIt();
		
		String[] expected = new String[] {"1"};
		Assert.assertTrue(Arrays.equals(expected, result));

	}

	
	@Test
	public void fizz_buzz_till_twenty() {
		FizzBuzz fizzBuzz = new FizzBuzz(20);
		
		String[] expected = new String[] {
		"1",
		"2",
		"Fizz",
		"4",
		"Buzz",
		"Fizz",
		"7",
		"8",
		"Fizz",
		"Buzz",
		"11",
		"Fizz",
		"Fizz",
		"14",
		"FizzBuzz",
		"16",
		"17",
		"Fizz",
		"19",
		"Buzz"};
		
		String[] result = fizzBuzz.sayIt();
		
		Assert.assertTrue(Arrays.equals(expected, result));

	}

}
