class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        int smallestLen = strs[0].length();

        for(String str: strs) {
            smallestLen = Math.min(smallestLen, str.length());
        }

        int idx = 0;
        for(; idx<smallestLen; idx++) {
            char ch = strs[0].charAt(idx);
            for(String str: strs) {
                if(ch != str.charAt(idx)) {
                    return str.substring(0,idx);
                }
            }
        }

        return strs[0].substring(0,smallestLen);
    }
}