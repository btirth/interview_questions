package arraysAndString;

public class CTCI_1_4_2 {
	boolean checkPalindrome(String s) {
		int[] char_set = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		int countOdd = 0;
		for(char c: s.toCharArray()) {
			int x = char_set[getValue(c)];
			if(x!=-1) {
				char_set[x]++;
				if(char_set[x]%2 == 1) {
					countOdd++;
				}
				else {
					countOdd--;
				}
			}
		}
		
		return countOdd<=1;
	}
	
	int getValue(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int c_value = Character.getNumericValue(c);
		
		if(c_value>=a && c_value<=z) {
			return c_value - a;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "adhdha";
		CTCI_1_4_2 a = new CTCI_1_4_2();
		System.out.println(s + " is palindrome: " + a.checkPalindrome(s));
	}

} 