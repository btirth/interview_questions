/* Is Unique: Implement an algorithm to determine if a string has all unique characters. */

package CTCI;
public class CTCI_1_1 {
	static boolean isUniqueChars(String str) {
		boolean[] char_set = new boolean[128];
		int n = str.length();
		
		if(n>128) {
			return false;
		}
		
		for(int i=0;i<n;i++) {
			int val = str.charAt(i);
			if(char_set[val]==true) {
				return false;
			}
			else {
				char_set[val]=true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "asdfghjk";
		String str2 = "aasdffa";
		
		if(isUniqueChars(str1)==true) {
			System.out.println(str1+" -> All Characters are Unique");
		}
		else {
			System.out.println(str1+" -> All Characters are Not Unique");
		}
		
		if(isUniqueChars(str2)==true) {
			System.out.println(str2+" -> All Characters are Unique");
		}
		else {
			System.out.println(str2+" -> All Characters are Not Unique");
		}
		

		
	}

}
