/*Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other.*/


package CTCI;

public class CTCI_1_2_1 {
	boolean isPermutation(String s,String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[128];    //Assumption
		char[] char_set = s.toCharArray();
		for(char c:char_set) {
			letters[c]++;
		}
		char[] char_set2 = t.toCharArray();
		for(char c:char_set2) {
			letters[c]--;
			if(letters[c] < 0) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CTCI_1_2_1 c2 = new CTCI_1_2_1();
		System.out.println(c2.isPermutation("sfc", "fsc"));
		System.out.println(c2.isPermutation("sfc", "sfa"));
		
	}

}
