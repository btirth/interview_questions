/*  Is Unique: Implement an algorithm to determine if a string has all unique characters. */



package arraysAndString;

public class CTCI_1_1_1 {
	
	boolean isUnique(String s) {
		//let's  assume given string has char from 128 char alphabets 
		if(s.length()>128) {
			return false;
		}
		
		boolean[] char_set = new boolean[128]; 
		for(int i=0;i<s.length();i++) {
			int value = s.charAt(i);
			if(char_set[value]) {
				return false;
			}
			char_set[value] = true;
		}
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CTCI_1_1_1 a = new CTCI_1_1_1();
		
		String s1 = "ghdfsk";    //true
		String s2 = "fdsagf";     //false
		
		System.out.println(s1 + "has all unique char: " + a.isUnique(s1));
		System.out.println(s2 + "has all unique char: " + a.isUnique(s2));
		
	}

}

