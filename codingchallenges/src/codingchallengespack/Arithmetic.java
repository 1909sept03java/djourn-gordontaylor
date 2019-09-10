package codingchallengespack;

public interface Arithmetic {

	int adder(int num1,int num2);
	int subtracter(int num1,int num2);
	int multiplier(int num1,int num2);
	float divider(int num1,int num2);
	
	
}
class testClass implements Arithmetic{
	

	public int adder(int num1, int num2) {
		
		return num1+num2;
		
	}
	public int subtracter(int num1, int num2) {
		
		return num1-num2;
		
	}
	public int multiplier(int num1, int num2) {
		
		return num1*num2;
	}
	public float divider(int num1, int num2) {
		
		return  (float)num1/(float)num2;
	}
	
	public static void main (String[] args) 
    { 
        testClass tester = new testClass(); 
        System.out.println("1 + 2 = " + tester.adder(1, 2)); 
        System.out.println("1 - 2 = " + tester.subtracter(1, 2)); 
        System.out.println("1 * 2 = " + tester.multiplier(1, 2));
        System.out.println("1 / 2 = " + tester.divider(1, 2));
        
    } 
	
	
}