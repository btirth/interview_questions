class Solution {
    public int possibleStringCount(String word) {
        int count = 1;
        int len = word.length();
        int ans = 1;

        for(int i=1; i<len; i++) {
            if(word.charAt(i) != word.charAt(i-1)) {
                
                ans += (count - 1);
                count = 0;
                
            } 

            count++;
        }

        ans += (count - 1);
        return ans;
    }
}