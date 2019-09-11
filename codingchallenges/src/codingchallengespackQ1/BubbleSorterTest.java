package codingchallengespackQ1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BubbleSorterTest {

	@Test
	void test() {
		
		
		int testarr[]= {1,2,3};
		int testarr2[] = {1,2,3};
		
		
		
		 assertArrayEquals(BubbleSorter.SortArray(testarr2),testarr);
		
		
//		fail("Not working");
	}

}
