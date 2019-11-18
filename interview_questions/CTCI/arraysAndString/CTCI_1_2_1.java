/*  Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other.
 
*/

package arraysAndString;

import java.util.Arrays;


public class CTCI_1_2_1 {
	
	String sort(String s) {
		char[] char_set = s.toCharArray();
		Arrays.sort(char_set);
		return new String(char_set);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcdfhje";
		String s2 = "cdfhjeab";
		CTCI_1_2_1 a = new CTCI_1_2_1();
		System.out.println(s1 + "is permuntation of " + s2 + ": " + a.sort(s1).equals(a.sort(s2)) );
	}

}
