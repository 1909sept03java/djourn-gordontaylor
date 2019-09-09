package codingchallengespack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mutations {

	/*
	 * 
	 * Minimum Mutations!
	 * 
	 * A gene string can be represented by an 8-character long string, with choices
	 * from "A", "C", "G", "T".
	 * 
	 * Suppose we need to investigate about a mutation (mutation from "start" to
	 * "end"), where ONE mutation is defined as ONE single character changed in the
	 * gene string.
	 * 
	 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
	 * 
	 * Also, there is a given gene "bank", which records all the valid gene
	 * mutations. A gene must be in the bank to make it a valid gene string.
	 * 
	 * Now, given 3 things - start, end, bank, your task is to determine what is the
	 * minimum number of mutations needed to mutate from "start" to "end". If there
	 * is no such a mutation, return -1. If the start and end string are the same,
	 * return 0.
	 * 
	 * Example:
	 * 
	 * start: "AACCGGTT" end: "AAACGGTA" bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
	 * 
	 * return: 2
	 * 
	 * Note: Starting point is assumed to be valid, so it might not be included in
	 * the bank. If multiple mutations are needed, all mutations during in the
	 * sequence must be valid.
	 * 
	 * Organize your solution into a driver class (with a main method) and utility
	 * class containing the logical implementation. Points will be docked for code
	 * that's too tightly coupled. The starting and ending sequences and mutation
	 * bank may be (in descending order of points awarded) read from a file, input
	 * through the console, or hardcoded in the driver class.
	 * 
	 * Submit your solution in your Week1Challenge folder in your repository (if you
	 * wrote your solution in Eclipse/STS, make sure no compiled .class files or
	 * project metadata make their way up to GitHub).
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		System.out.println("please enter an 8 digit gene code Starting Point: ");
		System.out.printf("%n");
		Scanner scan = new Scanner(System.in);

		String gene1 = scan.nextLine();; // this is Starting point
		gene1 = gene1.replaceAll("\\s+", "");
		
		System.out.println("please enter an 8 digit gene code Ending Point: ");
		System.out.printf("%n");
		Scanner scan2 = new Scanner(System.in);

		String gene2 = scan.nextLine();; // this is Ending point
		gene2 = gene2.replaceAll("\\s+", "");
		
		

		mutationChecker(gene1, gene2);

	}

	static int mutationChecker(String gene1, String gene2)  {
		
		gene1 = gene1.toUpperCase();
		gene2 = gene1.toUpperCase();
		String[] genebank = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
		

	
		
		if(gene1.length() < 8) {
			
			System.out.println("Your gene code is invalid");
			
		}
		
		String testmutation = gene1;

		int mutations = 0;
		
		
		Scanner sc;
		try {
			sc = new Scanner(new File("src\\codingchallengespack\\genebank.txt"));
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
			  lines.add(sc.nextLine());
			   genebank = lines.toArray(new String[0]);
		}} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Using default bank");
			
		}
		
		

		

		//

		if ((Arrays.asList(genebank).contains(gene2)) == false) {

			System.out.println(gene2 + " is not in the genebank");
			return -1;

		}

		if (gene1 == gene2) {
			System.out.println("The submitted genes strings are identical");
			return 0;
		}

		for (int i = 0; i < 8; i++) {

			if (gene1.charAt(i) != gene2.charAt(i)) {

				StringBuilder newTest = new StringBuilder(testmutation);
				newTest.setCharAt(0, gene2.charAt(i));

				if ((Arrays.asList(genebank).contains(newTest.toString())) == false) {

					System.out.println("Your gene contains an invalid mutation");
					return -1;

				}

				testmutation = newTest.toString();

				mutations++;

			}

		}

		System.out.println(mutations);
		return 2;

	}

}
