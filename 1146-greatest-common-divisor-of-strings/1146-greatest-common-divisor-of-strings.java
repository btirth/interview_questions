class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int idx = 0;
        int l1 = str1.length();
        int l2 = str2.length();
        
        if(l1 > l2) {
            return gcdOfStrings(str2, str1);
        }

        for(; idx<l1; idx++) {
            if(str1.charAt(idx) != str2.charAt(idx)) {
                break;
            }
        }

        for(int i=idx-1; i>=0; i--) {
            if(l1%(i+1) == 0 && l2%(i+1) == 0 && isPossible(str1, str2, i)) {
                return str1.substring(0, i+1);
            }
        }

        return "";
    }

    boolean isPossible(String s1, String s2, int k) {
        String t = s1.substring(0, k+1);
        return s1.replace(t, "").isEmpty() && s2.replace(t, "").isEmpty();
    }
}