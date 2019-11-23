/*

String Rotation: Assume you have a method i 5Su b 5 tr ing which checks if one word is a substring
of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
call to i5Sub5tring (e.g., "waterbottle" is a rotation of" erbottlewat").

Hint: if we imagine s1 = xy then s2 will be yx.

s1 = xy
s2 = yx
s1s1 = xyyx
So that s2 will be substring of s1s1.

*/


package arraysAndString;

public class CTCI_1_9_1 {
	
	boolean isRotation(String s1,String s2) {
		if(s1.length()==s2.length() && s1.length()!=0) {
			String s1s1 = s1 + s1;
		//	return isSubString(s1s1,s2);    //assuption
 		}
		
		
		
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		
		CTCI_1_9_1 a = new CTCI_1_9_1();
		
	}

}
