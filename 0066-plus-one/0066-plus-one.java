class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        int[] ans = new int[n+1];
        for(int i=n-1; i>=0; i--) {
            if(carry == 0) {
                ans[i + 1] = digits[i];
                continue;
            }
            
            ans[i + 1] = digits[i] + carry;
            carry = 0;
            if(ans[i + 1] > 9) {
                carry = ans[i + 1]/10;
                ans[i + 1] %= 10;
            }
        }

        if(carry == 0) {
            return Arrays.copyOfRange(ans, 1, n+1);
        }

        ans[0] = carry;
        return ans;
    }
}