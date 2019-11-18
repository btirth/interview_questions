/*  Palindrome Permutation: Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.    */

package arraysAndString;

public class CTCI_1_4_1 {
	boolean checkPalindrome(String s) {
		//char[] char_set = s.toCharArray();
		int[] char_value = new int[128];
		boolean flag = false;
		for(int i=0;i<s.length();i++) {
			char_value[s.charAt(i)]++;
			
		}
		
		for(int j=0;j<char_value.length;j++) {
			if((char_value[j]%2) != 0) {
				if(flag) {
					return false;
				}
				else {flag = true;}
			}
		}
				
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "adhdha";
		CTCI_1_4_1 a = new CTCI_1_4_1();
		
		System.out.println(s + " is palindrome: " + a.checkPalindrome(s));
	}

}
