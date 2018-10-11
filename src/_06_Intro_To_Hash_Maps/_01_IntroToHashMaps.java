package _06_Intro_To_Hash_Maps;

import java.util.HashMap;

public class _01_IntroToHashMaps {
	public static void main(String[] args) {
		long start, end;
		final int index = 1001;
		//1. Create a HashMap called roots with Integers for the keys and Doubles for the values.
		HashMap<Integer,Integer> roots = new HashMap<Integer,Integer>();
		//2. Using a for-loop, add 500 entries to your HashMap. The key entry will be the 
		//   current iteration of the loop (i). The value entry will be the square root of i.
		start = System.currentTimeMillis();
		for(int i = 0; i < index; i++) {
			roots.put(i, (int)Math.pow(i, 2));
		}
		
		//3. Iterate through all the entries in your HashMap displaying the keys with their respective
		//   square roots (values). Use the following format.

		//   The square Root of 0 is 0.0
		//   The square Root of 1 is 1.0
		//   The square Root of 2 is 1.4142135623730951
		//   The square Root of 3 is 1.7320508075688772
		
		for(int i = 0; i < index; i++) {
			System.out.println("The Square Root of "+roots.get(i)+" is "+i);
		}
		end = System.currentTimeMillis();
		
		System.out.println();
		System.out.println();
		long ms = end-start;
		if(ms < 1000) {
			System.out.println(ms+"ms");
		} else {
			System.out.println(ms/1000+"s");
		}
	}
}
