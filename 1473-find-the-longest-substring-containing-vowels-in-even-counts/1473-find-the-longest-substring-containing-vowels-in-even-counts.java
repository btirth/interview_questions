class Solution {
    public int findTheLongestSubstring(String s) {
        int binary = 0; // a e i o u
        // 16a 8e 4i 2o 1u
        HashMap<Integer, Integer> map = new HashMap<>();
        int longestSubstringLength = 0;
        map.put(0, -1);
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == 'a') {
                binary = binary ^ (1<<4);
            } else if(ch == 'e') {
                binary = binary ^ (1<<3);
            } else if(ch == 'i') {
                binary = binary ^ (1<<2);
            } else if(ch == 'o') {
                binary = binary ^ (1<<1);
            } else if(ch == 'u') {
                binary = binary ^ (1);
            }

            if(map.containsKey(binary)) {
                longestSubstringLength = 
                    Math.max(longestSubstringLength, i - map.get(binary));
            } else {
                map.put(binary, i);
            }
        }

        return longestSubstringLength;
    }
}