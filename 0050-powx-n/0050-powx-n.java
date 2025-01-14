class Solution {
    HashMap<Long, Double> processed = new HashMap<>();
    public double myPow(double x, int n) {
        return pow(x, n);
    }

    double pow(double x, long n) {
        boolean isNeg = n<0;
        n = Math.abs(n);

        if(n == 0) {
            return 1;
        }

        if(processed.containsKey(n)) {
            return processed.get(n);
        }

        double val;
        if(n%2 == 1) {
            val = x * pow(x, n-1);
        } else {
            val = pow(x, n/2) * pow(x, n/2);
        }

        if(isNeg) {
            val = 1/val;
        }

        processed.put(n, val);
        return val;
    }
}