class Solution {
    public String makeGood(String s) {
        if(s.length()==0 ||s.length()==1) {
            return s;
        }
        char[] str = new char[s.length()];
        
        int i=0;
        for(int j=0; j<s.length(); j++) {
            char current = s.charAt(j);
            if(i>0 && Math.abs(current-str[i-1])==32) {
                System.out.println("if");
                i--;
            } else {
                str[i] = current;
                i++;
            }
        }
        
        return new String(str, 0, i);
        
    }
}