class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;

        for(int i=n-1; i>=0; i--) {
            int val = digits[i] + carry;
            digits[i] = val%10;
            carry = val/10;
            if(carry == 0) {
                return digits;
            }
        }

        int[] ans = new int[n+1];
        ans[0] = carry;
        for(int i=0; i<n; i++) {
            ans[i+1] = digits[i];
        }

        return ans;
    }
}