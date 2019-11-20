/*

One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.

 */


package arraysAndString;

public class CTCI_1_5_1 {
	boolean oneEdit(String s,String t) {
		
		int index_s = 0;
		int index_t = 0;
		
		while(index_s<s.length() && index_t<t.length()) {
			if(s.charAt(index_s)!=t.charAt(index_t)) {
				if(index_s!=index_t) {
					System.out.println(s.charAt(index_s)+t.charAt(index_t));
					return false;
				}
				index_s++;
			}
			else {
				index_s++;
				index_t++;
			}
			
		}
		
		return true;
	}
	
	boolean oneReplace(String s,String t) {
		
		boolean foundReplace = false;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=t.charAt(i)) {
				if(foundReplace) {
					return false;
				}
				foundReplace = true;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "perl";
		String s2 = "prl";
		String s3 = "paal";
		
		CTCI_1_5_1 a = new CTCI_1_5_1();
		
		if(s1.length()>s2.length()) {
			System.out.println(s1 + "  " + s2 + "  : " + a.oneEdit(s1, s2));
		}
		else {
			System.out.println(s1 + "  " + s2 + "  : " + a.oneEdit(s2, s1));
		}
		
		if(s1.length()==s3.length()) {
			System.out.println(s1 + "  " + s3 + "  : " + a.oneReplace(s1, s3));
		}
		
	}

}
