/*Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other.*/

package CTCI;
public class CTCI_1_2{
	String sort(String str) {
		char[] character = str.toCharArray();
		java.util.Arrays.sort(character);
		return new String(character);
	}
	
	boolean isPermutation(String s,String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		return sort(s).equals(sort(t));
	
	}
	
	public static void main(String[] args){
		CTCI_1_2 c2 = new CTCI_1_2();
		System.out.println(c2.isPermutation("sfc", "fsc"));
		System.out.println(c2.isPermutation("sfc", "sfa"));
	}
}