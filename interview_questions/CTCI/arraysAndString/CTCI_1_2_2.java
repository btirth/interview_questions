package arraysAndString;

public class CTCI_1_2_2 {
	boolean checkPermutation(String s,String t) {
		if(s.length() != t.length()) return false;
		
		int[] char_set = new int[128];
		char[] char_s = s.toCharArray();
		char[] char_t = t.toCharArray();
		
		for(char c:char_s){
			char_set[(int)c]++;
		}
		
		for(char c:char_t){
			char_set[(int)c]--;
		}
		
		for(int i=0;i<char_set.length;i++) {
			if(char_set[i]!=0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CTCI_1_2_2 a = new CTCI_1_2_2();
		String s1 = "abcdfhje";
		String s2 = "cdfhjeaz";
		
		System.out.println(s1 + "is permuntation of " + s2 + ": " + a.checkPermutation(s1,s2) );
		
	}

}
