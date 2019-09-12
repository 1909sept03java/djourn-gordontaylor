package codingchallengeQ9;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class PrimeFinderTest {

	@Test
	void test() {
		ArrayList <Integer> allnumbers;
		allnumbers = new ArrayList<Integer>(100);
		
		for (int i = 0; i < 101; i++) {
			allnumbers.add(i);
			
			
		}
		
		PrimeFinder.PrimeFinding(allnumbers);

	}

}
