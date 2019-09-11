package codingchallengespackQ1;

import java.util.Arrays;

public class BubbleSorter {
	
	BubbleSorter(){};
	
	static int[] SortArray(int[] needsort) {
		
		System.out.println("unsorted: " + Arrays.toString(needsort));
		
		for (int j = 0; j < needsort.length; j++) {
			for (int i = 0; i < needsort.length-1; i++) {
				
				if(needsort[i]>needsort[i+1]) {
					
					int temp = needsort[i+1];
					needsort[i+1] = needsort[i];
					needsort[i] = temp;
					
					
					
				}
				
			}
		}
		
		System.out.println("sorted: " + Arrays.toString(needsort));
		return needsort;
		
		
	}

}
