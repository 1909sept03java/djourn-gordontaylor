package Fibonnacci;

public class FibCounter {
	
	static void FibPrinter(int start, int prev, int num){
		
		if (num >= 0) {
			if(start == 0) {
				System.out.println(start);
				start = 1;
				prev  = 0;
			}
			if(start == 1) {
				System.out.println(start);
				start =2;
				prev = 1;
			}
				
			int temp = start;
			start = start+prev;
			prev = temp;
			System.out.println(start);
			num = num -1;
			
			FibPrinter(start,prev,num);
			
			
			
			
			
			
			
			
		}
		
		
		
		
	}
	

}
