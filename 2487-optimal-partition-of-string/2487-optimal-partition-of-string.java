class Solution {
    public int partitionString(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        boolean[] charExists = new boolean[26];

        while(right < s.length()) {
            if(charExists[s.charAt(right) - 'a']) {
                count++;

                while(left < right) {
                    charExists[s.charAt(left) - 'a'] = false;
                    left++;
                }
            }

            charExists[s.charAt(right) - 'a'] = true;
            right++;
        }

        return count + 1;
    }
}