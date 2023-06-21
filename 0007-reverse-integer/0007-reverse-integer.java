class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        boolean isNeg = x<0;
        x = Math.abs(x);
        int res = 0;

        while(x > 0) {
            int digit = x%10;
            x = x/10;

            if(res > max/10 || (res == max/10 && digit > max%10)) {
                return 0;
            }

            if(res < min/10 || (res == min/10 && digit < min%10)) {
                return 0;
            }

            res *= 10;
            res += digit;
        } 
    
        return isNeg ? -1*res : res;
    }
}