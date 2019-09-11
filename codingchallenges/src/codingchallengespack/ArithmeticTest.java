package codingchallengespack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import codingchallengespack.mathClass;

class ArithmeticTest {
	
	private static mathClass calculator;
	
	@BeforeClass
	public static void testClass() {
		
		 calculator = mathClass.getInstance();		
		
	}

	@Test
	 static void test(mathClass calculator) {
		System.out.println("1 + 2 = " + calculator.adder(1, 2)); 
        System.out.println("1 - 2 = " + calculator.subtracter(1, 2)); 
        System.out.println("1 * 2 = " + calculator.multiplier(1, 2));
        System.out.println("1 / 2 = " + calculator.divider(1, 2));
        
        
       assertEquals(3,calculator.adder(1, 2));
        
	}

}
