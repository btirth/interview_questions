class Solution {
    public int reverse(int x) {
        long val = 0;
        int idx = 10;
        boolean isNeg = x < 0;
        x =  Math.abs(x);

        while(x > 0) {
            int leastSignificantDigit = x%10;
            x /= 10;

            val = (val * idx) + (leastSignificantDigit);
        }

        if(!isNeg && val > Integer.MAX_VALUE) {
            return 0;
        }

        if(isNeg && (-1*val) < Integer.MIN_VALUE) {
            return 0;
        }

        if(isNeg) {
            return -1*(int)val;
        }
        return (int)val;
    }
}