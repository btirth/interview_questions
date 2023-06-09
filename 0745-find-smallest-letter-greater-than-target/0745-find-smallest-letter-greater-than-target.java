class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length-1;

        int ans = 0;
        while(l <= r) {
            int mid = (r+l)/2;
            if(letters[mid] > target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return letters[ans];
    }
}