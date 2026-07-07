class Solution {
    public long sumAndMultiply(int n) {
        long res = 0;
        long sum = 0;
        String temp = "";
        int idx = 0;

        while(n > 0) {
            int digit = n % 10;
            n /= 10;

            if(digit > 0) {
                sum += digit;
                res = (digit * (long)Math.pow(10, idx)) + res;
                idx += 1;
            }
        }

        return res * sum;
    }
}