/*  URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters  */

package arraysAndString;

public class CTCI_1_3_1 {
	String replaceSpace(String s) {
		int countSpace = 0;
		char[] char_set = s.toCharArray();
		for(int i=0;i<char_set.length;i++) {
			if(char_set[i] == ' ') {
				countSpace++;
			}
		}
		
		int index = char_set.length + (countSpace*2);
		int a = 0;
		char[] finalStr = new char[index];
		for(int j=0;j<char_set.length;j++) {
			if(char_set[j]==' ') {
				finalStr[a] = '%';
				finalStr[a+1] = '2';
				finalStr[a+2] = '0';
				a += 3;
			}
			else {
				finalStr[a] = char_set[j];
				a++;
			}
		}
		
		return new String(finalStr);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CTCI_1_3_1 a = new CTCI_1_3_1();
		String s = "Java is love";
		System.out.println(s +" = "+ a.replaceSpace(s));
		
		
	}

}
