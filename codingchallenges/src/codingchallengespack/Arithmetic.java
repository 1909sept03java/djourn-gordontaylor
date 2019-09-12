package codingchallengespack;
import codingchallengespack.Arithmetic;


public interface Arithmetic {

	int adder(int num1,int num2);
	int subtracter(int num1,int num2);
	int multiplier(int num1,int num2);
	float divider(int num1,int num2);
	
	
}
class  mathClass implements Arithmetic{
	
	private static final mathClass mathematics = new mathClass();
	mathClass() {};
	
	
	@Override
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
	
	public static mathClass getInstance() {
return mathematics;	
	}
}