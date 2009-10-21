package com.strumtheagile.katafizzbuzz;

import junit.framework.Assert;

import org.junit.Test;

public class FizzBuzzTest {
	
	@Test
	public void fizz_buzz_for_first() {
		FizzBuzz fizzBuzz = new FizzBuzz();
		
		String result = fizzBuzz.atTime(1);
		
		Assert.assertEquals("1", result);
	}
	
	@Test
	public void fizz_buzz_for_second() {
		FizzBuzz fizzBuzz = new FizzBuzz();
		
		String result = fizzBuzz.atTime(2);
		
		Assert.assertEquals("2", result);
	}
	
	@Test
	public void fizz_buzz_for_third() {
		FizzBuzz fizzBuzz = new FizzBuzz();
		
		String result = fizzBuzz.atTime(3);
		
		Assert.assertEquals("Fizz", result);
	}
	
	@Test
	public void fizz_buzz_for_fifth() {
		FizzBuzz fizzBuzz = new FizzBuzz();
		
		String result = fizzBuzz.atTime(5);
		
		Assert.assertEquals("Buzz", result);
	}

}
