package arraysAndString;

public class CTCI_1_6_1 {
	
	String compressStr(String s) {
		StringBuilder compressedStr = new StringBuilder();
		
		int count = 0;
		
		for(int i=0;i<s.length();i++) {
			if(i+1 >= s.length() || s.charAt(i)!=s.charAt(i+1)) {
				count++;
				compressedStr.append(s.charAt(i));
				compressedStr.append(count);
				count = 0;
			}
			else {
				count++;
			}
		}
		
		if(compressedStr.length()>s.length()) {
			return s;
		}
		
		return compressedStr.toString();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CTCI_1_6_1 a = new CTCI_1_6_1();
		
		String s = "aaaabbccc";
		System.out.println(s + " : " + a.compressStr(s));

	}

}
