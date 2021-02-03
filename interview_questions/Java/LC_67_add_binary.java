class Solution {
    StringBuilder sb = new StringBuilder();
    int c = 0;  //carry
    int i = 0;
    public String addBinary(String a, String b) {
        String s1 = a.length() >= b.length() ? a : b;
        String s2 = a.length() >= b.length() ? b : a;
        int l1 = s1.length();
        int l2 = s2.length();
        int i = 0;
        for(; i<s2.length(); i++) {
            sb.insert(0, add(s1.charAt(l1-i-1), s2.charAt(l2-i-1)));
        }
        for(; i<s1.length(); i++) {
            
            sb.insert(0, add(s1.charAt(l1-i-1), '0'));
        }
        if(c!=0) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
    
    char add(char c1, char c2) {
        int sum = Character.getNumericValue(c1) + Character.getNumericValue(c2) + c;
        
        if(sum == 0) {
            return '0';
        } else if(sum == 1) {
            c=0;
            return '1';
        } else if(sum ==2) {
            c = 1;
            return '0';
        } else if(sum == 3) {
            c = 1;
            return '1';
        }
        
        return '0';
    }
}