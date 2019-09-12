package PrintTriangle;

public class TriPrinter {
	
	 static void PrintTri(){
		
		
		 for (int i=1; i<10; i++) {
			 
	        
	         for (int j=0;j<i; j++) {
	        	 
	        	 if((j/2)*2 == j)
	        		 System.out.print("0");
	        	 else
	        		 System.out.print("1");
	         }
	         System.out.println(" ");
	      }
		
	}
	
	
	

}
