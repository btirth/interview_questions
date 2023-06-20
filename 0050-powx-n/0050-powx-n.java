class Solution {
    HashMap<Integer, Double> dp = new HashMap<>();
    public double myPow(double x, int n) {
        if(x == 0) {
            return 0;
        }

        if(n<0) {
            return 1.0/helper(x, -1*n);
        }

       return helper(x, n);
    }

    double helper(double x, int n) {
        if(n == 1) {
            return x;
        }

        if(n == 0) {
            return 1;
        }

        if(dp.containsKey(n)) {
            return dp.get(n);
        }
        
        double ans = -1;
        if(n%2 == 0) {
            ans = helper(x, n/2) * helper(x, n/2);
        } else {
            ans = x * helper(x, n/2) * helper(x, n/2);
        }

        dp.put(n, ans);
        return ans;
    }
}