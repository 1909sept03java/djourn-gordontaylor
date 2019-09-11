package Stringreverse;

public class StringReverser {
	
	
	static String Reverser(String word){
		
		char [] reversed;
		reversed = new char[word.length()];
		int counter = 0;
		
		for (int i = word.length()-1; i > -1 ; i--) {
			
			reversed[counter] = word.charAt(i);
			
			counter++;
			
			
			
			
		}
		String revWord = new String(reversed);
		
		System.out.println(revWord);
	return 	revWord;
	}

}
