class Solution {
    public double myPow(double x, int n) {
        return pow(x, n);
    }

    double pow(double x, long n) {
        boolean isNeg = n<0;
        n = Math.abs(n);

        if(n == 0) {
            return 1;
        }

        double val;
        if(n%2 == 1) {
            val = x * pow(x, n-1);
        } else {
            double tempVal = pow(x, n/2);
            val = tempVal * tempVal;
        }

        return isNeg ? 1/val : val;
    }
}