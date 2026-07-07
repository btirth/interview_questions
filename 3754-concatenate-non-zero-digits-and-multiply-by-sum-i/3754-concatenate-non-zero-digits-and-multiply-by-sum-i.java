class Solution {
    public long sumAndMultiply(int n) {
        long res = 0;
        long sum = 0;
        long mult = 1;

        while(n > 0) {
            int digit = n % 10;
            n /= 10;

            if(digit > 0) {
                sum += digit;
                res = (digit * mult) + res;
                mult *= 10;
            }
        }

        return res * sum;
    }
}