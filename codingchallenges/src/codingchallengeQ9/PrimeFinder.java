package codingchallengeQ9;

import java.util.ArrayList;

public class PrimeFinder {
	
	

	static void PrimeFinding(ArrayList <Integer> allnumbers ) {
		
		
		
		for(int i = 3; i <allnumbers.size()-1; i++) {
			int range = allnumbers.get(i)/2;
			for(int j = 2; j <= range; j++) {
				if(allnumbers.get(i)%j==0){  
					i = i+1;
					range = allnumbers.get(i)/2;
					j=0;
				     break;      
				    }      
				
			}
			
			
			System.out.println(allnumbers.get(i).toString());
			
		}
			
			
			
		}
	
	
}
