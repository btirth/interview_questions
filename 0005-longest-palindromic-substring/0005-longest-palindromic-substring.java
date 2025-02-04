class Solution {
    public String longestPalindrome(String s) {
        int[] startEnd = new int[2];
        int[] ansStartEnd = new int[2];
        int n = s.length();

        for(int i=0; i<n; i++) {
            startEnd = helper(s, i-1, i+1);
            if(startEnd[1] - startEnd[0] > ansStartEnd[1] - ansStartEnd[0]) {
                ansStartEnd = startEnd;
            }
            startEnd = helper(s, i, i+1);
            if(startEnd[1] - startEnd[0] > ansStartEnd[1] - ansStartEnd[0]) {
                ansStartEnd = startEnd;
            }
            startEnd = helper(s, i-1, i);
            if(startEnd[1] - startEnd[0] > ansStartEnd[1] - ansStartEnd[0]) {
                ansStartEnd = startEnd;
            }
        }

        return s.substring(ansStartEnd[0], ansStartEnd[1]);
    }

    int[] helper(String s, int left, int right) {
        int n = s.length();

        while(left >=0 && right < n) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }

        return new int[]{left + 1, right};
    }
}