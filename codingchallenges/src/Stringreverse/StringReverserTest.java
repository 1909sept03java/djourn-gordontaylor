package Stringreverse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringReverserTest {

	@Test
	void test() {
		String testString = "potato";
		System.out.println(testString);
		
		
		testString.equals(StringReverser.Reverser(testString));
		
//		fail("Not yet implemented");
	}

}
