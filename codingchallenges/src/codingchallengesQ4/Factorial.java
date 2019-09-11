package codingchallengesQ4;

public class Factorial {
	
	static int factorial(int start) {
		
		if (start == 1) {
			
			return 1;
		}
		
		
		return start*factorial(start-1);
		
		
		
	}

}
